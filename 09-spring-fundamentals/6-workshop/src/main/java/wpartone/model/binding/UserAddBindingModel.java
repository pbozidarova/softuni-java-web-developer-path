package wpartone.model.binding;

import org.hibernate.validator.constraints.Length;

public class UserAddBindingModel {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String git;

    public UserAddBindingModel() {
    }

    @Length
    public String getUsername() {
        return username;
    }

    public UserAddBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserAddBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserAddBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserAddBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGit() {
        return git;
    }

    public UserAddBindingModel setGit(String git) {
        this.git = git;
        return this;
    }
}
