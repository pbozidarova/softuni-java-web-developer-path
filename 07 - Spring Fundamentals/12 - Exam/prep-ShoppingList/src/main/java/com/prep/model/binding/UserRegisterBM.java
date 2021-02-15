package com.prep.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBM {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;

    public UserRegisterBM() {
    }

    @NotBlank(message = "Username cannot be empty string")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters.")
    public String getUsername() {
        return username;
    }

    public UserRegisterBM setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank(message = "Password cannot be empty string.")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters.")
    public String getPassword() {
        return password;
    }

    public UserRegisterBM setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank(message = "Password cannot be empty string.")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters.")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBM setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Email(message = "Please enter valid email!")
    public String getEmail() {
        return email;
    }

    public UserRegisterBM setEmail(String email) {
        this.email = email;
        return this;
    }
}
