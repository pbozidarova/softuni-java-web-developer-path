package com.softuni.service.impl;

import com.softuni.model.enitity.RoleNameEnum;
import com.softuni.model.enitity.User;
import com.softuni.model.service.UserServiceModel;
import com.softuni.model.view.UserProfileViewModel;
import com.softuni.repository.UserRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.RoleService;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;

        this.roleService = roleService;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        user.setRole(roleService.findRole(RoleNameEnum.USER));

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser
                .setId(userServiceModel.getId())
                .setUsername(userServiceModel.getUsername())
                .setRole(userServiceModel.getRole().getName());
    }

    @Override
    public void logout() {
        currentUser
                .setId(null)
                .setUsername(null)
                .setRole(null);
    }

    @Override
    public List<String> findAllUsernames() {
        return userRepository.findAllUsernames();
    }

    @Override
    public void changeRole(String username, RoleNameEnum roleNameEnum) {
        User user = userRepository
                .findByUsername(username)
                .orElse(null);


            if(user.getRole().getName() != roleNameEnum){
                user.setRole(roleService.findRole(roleNameEnum));

                userRepository.save(user);
            }

    }

    @Override
    public User findById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserProfileViewModel findProfileById(Long id) {
        User user = userRepository.findById(id).orElse(null);

        UserProfileViewModel userProfileViewModel =
                this.modelMapper
                        .map(user, UserProfileViewModel.class)
                        .setHomeworkSet(
                                user.getHomeworkSet()
                                        .stream()
                                        .map(homework -> homework.getExercise().getName())
                        .collect(Collectors.toSet()));

        return userProfileViewModel;
    }

    @Override
    public Long findUsersCount() {
        return userRepository.count();
    }
}
