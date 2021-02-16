package com.spirngdata.service;

import com.spirngdata.model.dto.UserLoginDto;
import com.spirngdata.model.dto.UserRegisterDto;

public interface UserService {

    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();

    boolean isLoggedUserIsAdmin();
}
