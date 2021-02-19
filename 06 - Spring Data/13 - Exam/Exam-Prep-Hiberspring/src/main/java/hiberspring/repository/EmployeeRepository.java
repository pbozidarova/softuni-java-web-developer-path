package hiberspring.repository;

import hiberspring.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByFirstNameAndLastNameAndPosition(String firstName, String lastName, String position);


    @Query("SELECT e FROM Employee as e ORDER BY e.firstName, length(e.position) desc ")
    List<Employee> findAllOrdered();

    @Query("SELECT e from Employee as e WHERE e.branch.products.size > 0 " +
            "ORDER BY concat(e.firstName,' ' ,e.lastName), length(e.position) desc")
    List<Employee> findAllByBranchWithMoreThanOneProduct();

}
