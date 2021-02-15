package com.prep.service.impl;

import com.prep.model.entity.User;
import com.prep.model.service.UserServiceModel;
import com.prep.repository.UserRepository;
import com.prep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(UserServiceModel userSM) {
        try {
            this.userRepository.save(modelMapper.map(userSM, User.class));
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public UserServiceModel findByUserNameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
