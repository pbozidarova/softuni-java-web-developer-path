package bg.softuni.mobilele.mobilele.service.impl;

import bg.softuni.mobilele.mobilele.enums.UserRoleEnum;
import bg.softuni.mobilele.mobilele.model.entities.UserEntity;
import bg.softuni.mobilele.mobilele.model.entities.UserRoleEntity;
import bg.softuni.mobilele.mobilele.repository.UserRepository;
import bg.softuni.mobilele.mobilele.security.CurrentUser;
import bg.softuni.mobilele.mobilele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder,
                           UserRepository userRepository,
                           CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public boolean authenticate(String userName, String password) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(userName);

        if(userEntityOptional.isEmpty()){
            return false;
        } else {
            return passwordEncoder.matches(password,userEntityOptional.get().getPassword());
        }

    }

    @Override
    public void loginUser(String userName) {
        UserEntity user = userRepository.findByUsername(userName).orElseThrow();

        List<UserRoleEnum> userRoles = user.getUserRoles()
                .stream()
                .map(ur -> ur.getRole())
                .collect(Collectors.toList());

        currentUser
                .setAnonymous(false)
                .setName(user.getUsername())
                .setUserRoles(userRoles);
    }

    @Override
    public void logoutUser() {
        currentUser.setAnonymous(true);

    }
}
