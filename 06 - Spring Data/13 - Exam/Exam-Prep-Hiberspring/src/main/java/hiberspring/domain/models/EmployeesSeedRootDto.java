package hiberspring.domain.models;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeesSeedRootDto {

    @XmlElement(name = "employee")
    List<EmployeesSeedDto> employees;

    public EmployeesSeedRootDto() {
    }

    public List<EmployeesSeedDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeesSeedDto> employees) {
        this.employees = employees;
    }
}
