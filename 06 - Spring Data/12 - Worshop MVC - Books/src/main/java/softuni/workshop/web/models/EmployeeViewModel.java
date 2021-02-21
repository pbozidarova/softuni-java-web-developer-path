package softuni.workshop.web.models;

public class EmployeeViewModel {

    private String firstName;
    private String lastName;
    private int age;
    private String projectName;

    public EmployeeViewModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public EmployeeViewModel setAge(int age) {
        this.age = age;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public EmployeeViewModel setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s\n" +
                "\tAge: %d\n" +
                "\tProject name: %s", firstName, lastName, age, projectName);
    }
}
