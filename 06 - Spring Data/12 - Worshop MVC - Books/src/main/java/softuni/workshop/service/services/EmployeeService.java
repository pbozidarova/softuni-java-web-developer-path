package softuni.workshop.service.services;

import softuni.workshop.web.models.EmployeeViewModel;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface EmployeeService {

    void importEmployees() throws JAXBException;

    boolean areImported();

    String readEmployeesXmlFile();

    String exportEmployeesWithAgeAbove();

    List<EmployeeViewModel> findAllByAge();

    List<EmployeeViewModel> findAll();

    String employeesToJson();
}
