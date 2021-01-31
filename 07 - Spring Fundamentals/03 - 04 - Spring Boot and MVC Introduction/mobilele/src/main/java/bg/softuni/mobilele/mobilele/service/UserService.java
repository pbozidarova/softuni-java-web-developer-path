package bg.softuni.mobilele.mobilele.service;

public interface UserService {

    //returns true if the user is authenticated successfully
    boolean authenticate(String user, String password);

    void loginUser(String userName);
}
