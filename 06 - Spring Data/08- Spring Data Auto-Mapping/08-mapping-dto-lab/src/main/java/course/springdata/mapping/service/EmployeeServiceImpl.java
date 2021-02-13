package course.springdata.mapping.service;

import course.springdata.mapping.dao.EmployeeRepository;
import course.springdata.mapping.entity.Employee;
import course.springdata.mapping.exception.NonexistingEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return this.employeeRepository.findById(id).orElseThrow(() ->
                new NonexistingEntityException(
                        String.format("Employee with ID=%s does not exist.", id))
        );
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        employee.setId(null);
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        getEmployeeById(employee.getId());

        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee deleteEmployeeByID(long id) {
        Employee removed = getEmployeeById(id);
        employeeRepository.deleteById(id);

        return removed;
    }

    @Override
    public long getEmployeeCount() {
        return employeeRepository.count();
    }
}
