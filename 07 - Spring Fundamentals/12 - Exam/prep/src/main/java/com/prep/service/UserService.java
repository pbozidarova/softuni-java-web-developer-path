package com.prep.service;

import com.prep.model.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userSM);

    UserServiceModel findByUserNameAndPassword(String username, String password);
}
