package course.springdata.dao;

import course.springdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRopository extends JpaRepository<User, Long> {

}
