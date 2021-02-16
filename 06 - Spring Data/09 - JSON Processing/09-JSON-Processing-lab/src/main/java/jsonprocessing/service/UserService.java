package jsonprocessing.service;

import jsonprocessing.entity.Post;
import jsonprocessing.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User addUser(User user);
    User updateUser(User user);
    User deleteUser(Long id);
    long getUsersCount();
}
