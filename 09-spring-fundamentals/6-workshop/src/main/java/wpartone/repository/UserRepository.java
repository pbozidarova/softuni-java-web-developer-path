package wpartone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wpartone.model.entity.User;
import wpartone.model.service.UserServiceModel;
import wpartone.service.UserService;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
