package jsonprocessing.service.impl;

import jsonprocessing.dao.UserRepository;
import jsonprocessing.entity.User;
import jsonprocessing.exception.NonExistingEntityException;
import jsonprocessing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new NonExistingEntityException( String.format("User with Id=%s does not exist!", id)));

    }

    @Transactional
    @Override
    public User addUser(User user) {
        user.setId(null);
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        getUserById(user.getId());
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User deleteUser(Long id) {
        User removed = getUserById(id);
        userRepository.deleteById(id);
        return removed;
    }

    @Override
    public long getUsersCount() {
        return userRepository.count();
    }
}
