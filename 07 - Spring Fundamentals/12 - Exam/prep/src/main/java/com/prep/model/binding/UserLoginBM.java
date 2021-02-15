package com.prep.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBM {
    private String username;
    private String password;

    public UserLoginBM() {
    }

    @NotBlank(message = "Username cannot be empty string")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters.")
    public String getUsername() {
        return username;
    }

    public UserLoginBM setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank(message = "Password cannot be empty string.")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters.")
    public String getPassword() {
        return password;
    }

    public UserLoginBM setPassword(String password) {
        this.password = password;
        return this;
    }
}
