package xml_exercise.reporistories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xml_exercise.models.entities.Car;
import xml_exercise.models.entities.Customer;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByNameAndDateOfBirthAndYoungDriver(String name, LocalDateTime localDateTime, Boolean bul);

    @Query(value = "SELECT c FROM Customer as c order by c.dateOfBirth, c.youngDriver" )
    List<Customer> findAllByAndDateOfBirthAndIsYoungDriver();

    @Query("SELECT c FROM Customer as c WHERE c.sales.size > 0")
    List<Customer> findAllBySalesMade();
}
