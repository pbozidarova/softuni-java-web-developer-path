package com.spirngdata.service.impl;

import com.spirngdata.model.dto.UserDto;
import com.spirngdata.model.dto.UserLoginDto;
import com.spirngdata.model.dto.UserRegisterDto;
import com.spirngdata.model.entity.Role;
import com.spirngdata.model.entity.User;
import com.spirngdata.repository.UserRepository;
import com.spirngdata.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private UserDto userDto;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        User user = this.modelMapper
                .map(userRegisterDto, User.class);
        user.setRole(this.userRepository.count() == 0 ? Role.ADMIN : Role.USER);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        User user = this.userRepository.findByEmail(userLoginDto.getEmail());

        if(user == null) {
            System.out.println("Incorrect username / password");
        }else {
            this.userDto =
                    this.modelMapper.map(user, UserDto.class);
            System.out.printf("Successfully logged in %s%n", user.getFullName());
        }

    }

    @Override
    public void logout() {

        if(this.userDto == null){
            System.out.println("Cannot log out. No user was logged in.");
        }else {
            String name = this.userDto.getFullName();
            System.out.printf("User %s successfully logged out%n", name);
            this.userDto = null;
        }


    }

    @Override
    public boolean isLoggedUserIsAdmin() {
        return this.userDto.getRole().equals(Role.ADMIN);
    }
}
