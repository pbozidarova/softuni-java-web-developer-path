package wpartone.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserAddBindingModel {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String git;

    public UserAddBindingModel() {
    }

    @Length(min = 2, max = 10, message = "Username must be between 2 and 10 symbols.")
    public String getUsername() {
        return username;
    }

    public UserAddBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }
    @Length(min = 3, max = 10, message = "Password must be between 3 and 10 symbols.")
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

    @Email
    public String getEmail() {
        return email;
    }

    public UserAddBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+\\/.+",
            message = "Enter git address following this pattern!")
    public String getGit() {
        return git;
    }

    public UserAddBindingModel setGit(String git) {
        this.git = git;
        return this;
    }
}
