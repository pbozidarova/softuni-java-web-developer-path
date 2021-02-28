package hateoas.repository;

import hateoas.model.Course;
import hateoas.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

  @Query("select o from Order o where o.student.id=:studentId")
  public List<Order> findAllByStudentId(Long studentId);
}
