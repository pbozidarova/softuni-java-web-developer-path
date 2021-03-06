package unittesting.service;


import unittesting.entity.User;

public interface UserService {
    User register(String username, String password);
}
