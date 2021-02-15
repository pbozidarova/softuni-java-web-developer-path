package com.prep.service;

import com.prep.model.service.UserServiceModel;

public interface UserService {
    boolean register(UserServiceModel userSM);

    UserServiceModel findByUserNameAndPassword(String username, String password);
}
