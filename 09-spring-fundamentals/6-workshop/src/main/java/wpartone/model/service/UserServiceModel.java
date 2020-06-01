package wpartone.model.service;

import org.springframework.stereotype.Service;
import wpartone.model.entity.Role;

@Service
public class UserServiceModel extends BaseServiceModel {
    private String username;
    private String password;
    private String email;
    private String git;
    private RoleServiceModel role;

    public UserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGit() {
        return git;
    }

    public UserServiceModel setGit(String git) {
        this.git = git;
        return this;
    }

    public RoleServiceModel getRole() {
        return role;
    }

    public UserServiceModel setRole(RoleServiceModel role) {
        this.role = role;
        return this;
    }
}
