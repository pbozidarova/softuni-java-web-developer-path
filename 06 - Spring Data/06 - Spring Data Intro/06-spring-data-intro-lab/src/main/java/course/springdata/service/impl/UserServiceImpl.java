package course.springdata.service.impl;

import course.springdata.dao.UserRopository;
import course.springdata.entity.User;
import course.springdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private UserRopository userRopository;

    @Autowired
    public UserServiceImpl(UserRopository userRopository) {
        this.userRopository = userRopository;
    }

    @Override
    public User register(User user) {
        return this.userRopository.save(user);
    }
}
