package com.softuni.model.binding;


import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserRegisterBingingModel {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String git;

    public UserRegisterBingingModel() {
    }

    @NotNull
    @Length(min = 2, message = "Username length must be minimum 2 characters!")
    public String getUsername() {
        return username;
    }

    public UserRegisterBingingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotNull
    @Length(min = 3, message = "Username length must be minimum 2 characters!")
    public String getPassword() {
        return password;
    }

    public UserRegisterBingingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotNull
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBingingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
    @NotNull
    @Email(message = "Enter valid email address!")
    public String getEmail() {
        return email;
    }

    public UserRegisterBingingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotNull
    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+",
    message = "Enter valid git address!")
    public String getGit() {
        return git;
    }

    public UserRegisterBingingModel setGit(String git) {
        this.git = git;
        return this;
    }
}
