package softuni.workshop.data.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeDto {

    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement
    private int age;
    @XmlElement(name = "project")
    private ProjectDto projectDto;

    public EmployeeDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public EmployeeDto setAge(int age) {
        this.age = age;
        return this;
    }

    public ProjectDto getProjectDto() {
        return projectDto;
    }

    public EmployeeDto setProjectDto(ProjectDto projectDto) {
        this.projectDto = projectDto;
        return this;
    }
}
