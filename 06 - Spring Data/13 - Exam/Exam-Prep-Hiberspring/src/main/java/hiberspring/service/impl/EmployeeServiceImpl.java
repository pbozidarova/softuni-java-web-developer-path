package hiberspring.service.impl;

import hiberspring.common.GlobalConstants;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.domain.models.EmployeesSeedRootDto;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.repository.EmployeeRepository;
import hiberspring.service.EmployeeService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static hiberspring.common.GlobalConstants.SUCCESSFUL_IMPORT_MESSAGE;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeCardRepository employeeCardRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final BranchRepository branchRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeCardRepository employeeCardRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, BranchRepository branchRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeCardRepository = employeeCardRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.branchRepository = branchRepository;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return Files.readString(Path.of(GlobalConstants.EMPLOYEES_FILE_PATH));
    }

    @Override
    public String importEmployees() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        EmployeesSeedRootDto employeesSeedRootDto = this.xmlParser
                .parseXml(EmployeesSeedRootDto.class, GlobalConstants.EMPLOYEES_FILE_PATH);

        employeesSeedRootDto.getEmployees()
                .forEach(employeesSeedDto -> {
                    if(this.validationUtil.isValid(employeesSeedDto)){
                        if(this.employeeRepository
                                .findByFirstNameAndLastNameAndPosition(
                                        employeesSeedDto.getFirstName(),
                                        employeesSeedDto.getLastName(),
                                        employeesSeedDto.getPosition()) ==null){
                            Employee employee = this.modelMapper.map(employeesSeedDto, Employee.class);
                            Branch branch = this.branchRepository.findAllByName(employeesSeedDto.getBranch());
                            EmployeeCard card = this.employeeCardRepository.findAllByNumber(employeesSeedDto.getCard());

                            if(branch != null && employee != null) {
                                employee.setBranch(branch);
                                employee.setCard(card);
                                sb.append(String.format(SUCCESSFUL_IMPORT_MESSAGE,
                                        "Employee", employee.getFirstName() + " " + employee.getLastName()));

                                this.employeeRepository.saveAndFlush(employee);
                            }else {
                                sb.append("The branch or the card data is not valid!");
                            }

                        }else{
                            sb.append("This employee is already in the database!");
                        }
                    }else{
                        sb.append(GlobalConstants.INCORRECT_DATA_MESSAGE);
                    }
                    sb.append(System.lineSeparator());

                });

        return sb.toString();
    }

    @Override
    public String exportProductiveEmployees() {
        StringBuilder sb = new StringBuilder();

        List<Employee> employees = this.employeeRepository.findAllByBranchWithMoreThanOneProduct();

        employees
                .forEach(employee -> {
                    sb.append(String.format(
                            "Name: %s %s\n" +
                                    "Position: %s\n" +
                                    "Card Number: %s\n",
                            employee.getFirstName(), employee.getLastName(),
                            employee.getPosition(),
                            employee.getCard().getNumber()

                    )).append("-------------------------\n");
                });

        return sb.toString();
    }
}
