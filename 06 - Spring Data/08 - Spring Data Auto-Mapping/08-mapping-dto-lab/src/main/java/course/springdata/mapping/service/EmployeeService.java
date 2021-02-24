package course.springdata.mapping.service;

import course.springdata.mapping.entity.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    List<Employee> getAllManagers();

    List<Employee> getAllEmployeesBornBefore(LocalDate toDate);

    Employee getEmployeeById(long id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee deleteEmployeeByID(long id);
    long getEmployeeCount();

}
