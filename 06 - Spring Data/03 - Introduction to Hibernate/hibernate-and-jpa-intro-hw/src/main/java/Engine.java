import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private final BufferedReader reader;

    public Engine(EntityManager entityManager, BufferedReader reader) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        String task = "";
        System.out.println("Please choose a task number from 2 to 13: ");

        try {
            task = reader.readLine();
        } catch (IOException e) {

        }

        try {
            switch (task) {
                case "2":
//                  2.	Change casing
//                  Persist all towns from the database. Detach those whose name length is more than 5 symbols.
//                  Then transform the names of all attached towns to lowercase and save them to the database.
                    changeCasingEx2();
                    break;
                case "3":
//                  3.	Contains Employee
//                  Write a program that checks if a given employee name is contained in the database.
                    containsEmployeeEx3();
                    break;
                case "4":
//                  4.	Employees with Salary Over 50 000
//                  Write a program that gets the first name of all employees who have salary over 50 000.
                    employeesWithSalaryOver50000Ex4();
                    break;
                case "5":
//                  5.	Employees from Department
//                  Extract all employees from the Research and Development department. Order them by salary (in ascending order),
//                  then by id (in ascending order). Print only their first name, last name, department name and salary.
                    employeesFromDepartmentEx5();
                    break;
                case "6":
//                  6.	Adding a New Address and Updating Employee
//                  Create a new address with text "Vitoshka 15". Set that address to an employee with a last name, given as an input.
                    addingNewAddressEx6();
                    break;
                case "7":
//                  7.	Addresses with Employee Count
//                  Find all addresses, ordered by the number of employees who live there (descending).
//                  Take only the first 10 addresses and print their address text, town name and employee count.
                    addressesWithEmployeeCountEx7();
                    break;
                case "8":
//                  8.	Get Employee with Project
//                  Get an employee by his/her id. Print only his/her first name, last name, job title and projects (only their names).
//                  The projects should be ordered by name (ascending). The output should be printed in the format given in the example.
                    getEmployeeWithProjectsEx8();
                    break;
                case "9":
//                  9.	Find Latest 10 Projects
//                  Write a program that prints the last 10 started projects. Print their name, description, start and end date
//                  and sort them by name lexicographically. For the output, check the format from the example.
                    findLatest10ProjectsEx9();
                    break;
                case "10":
//                  10.	Increase Salaries
//                  Write a program that increases the salaries of all employees, who are in the Engineering, Tool Design, Marketing
//                  or Information Services departments by 12%. Then print the first name, the last name and the salary for the employees,
//                  whose salary was increased.
                    increaseSalariesEx10();
                    break;
                case "11":
//                  11.	Find Employees by First Name
//                  Write a program that finds all employees, whose first name starts with a pattern given as an input from the console.
//                  Print their first and last names, their job title and salary in the format given in the example below.
                    findEmployeesByFirstNameEx11();
                    break;
                case "12":
//                  12.	Employees Maximum Salaries
//                  Write a program that finds the max salary for each department. Filter the departments,
//                  which max salaries are not in the range between 30000 and 70000.
                    employeesMaxSalariesEx12();
                    break;
                case "13":
//                  13.	Remove Towns
//                  Write a program that deletes a town, which name is given as an input. The program should delete all addresses that are in the given town.
//                  Print on the console the number of addresses that were deleted. Check the example for the output format.
                    removeTownsEx13();
                    break;
                default:
                    System.out.println("No such task exists in the HW!");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeTownsEx13() throws IOException {
        System.out.println("Please enter a town in order to be deleted together with all its addresses: ");
        String town = reader.readLine();

        entityManager.getTransaction().begin();
        Town townToBeDeleted = this.entityManager.createQuery("SELECT t FROM Town t WHERE t.name = :town", Town.class)
                .setParameter("town", town)
                .getSingleResult();
        List <Address> addressesToBeDeleted = this.entityManager
                .createQuery("SELECT a FROM Address a WHERE a.town.name = :town", Address.class)
                .setParameter("town", town)
                .getResultList();

        addressesToBeDeleted.forEach(address -> address.getEmployees().forEach(employee -> employee.setAddress(null)));
        addressesToBeDeleted.forEach(this.entityManager::remove);
        this.entityManager.remove(townToBeDeleted);

        int countDelAddresses = addressesToBeDeleted.size();
        System.out.printf("%d address%s in %s deleted",
                countDelAddresses, countDelAddresses == 1 ? "" : "es", town);

        entityManager.getTransaction().commit();
    }

    private void employeesMaxSalariesEx12() {
       List<Object[]> results  = entityManager
                .createQuery("SELECT e.department.name, Max(e.salary) " +
                                "FROM Employee e "
                        + "GROUP BY e.department.name "
                        + "HAVING Max(e.salary) NOT BETWEEN 30000 AND 70000 "
                        , Object[].class)
                .getResultList();
        for (Object[] result : results) {
            System.out.println(
                     result[0] + " " + result[1]);
        }

    }

    private void findEmployeesByFirstNameEx11() throws IOException {
       System.out.println("Please enter a pattern with which a first name from the database starts: ");
       String pattern = reader.readLine();
       entityManager
               .createQuery("SELECT e FROM Employee e " +
                            "WHERE e.firstName LIKE concat(:pattern, '%')", Employee.class)
               .setParameter("pattern", pattern)
               .getResultStream()
               .forEach(e -> {
                   System.out.printf("%s %s - %s - ($%.2f)%n",
                           e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary());
               });
    }

    private void increaseSalariesEx10() {
        entityManager.getTransaction().begin();
        int affectedRows = entityManager
                .createQuery("UPDATE Employee e " +
                        "SET e.salary = e.salary * 1.12 " +
                        "WHERE e.department.id IN (1, 2, 4, 11)")
                .executeUpdate();
        entityManager.getTransaction().commit();

        System.out.println("Affected rows: " + affectedRows);

        entityManager
                .createQuery("SELECT e FROM Employee e WHERE e.department.id IN (1, 2, 4, 11)", Employee.class)
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s ($%.2f)%n", employee.getFirstName(), employee.getLastName(), employee.getSalary());
                });
    }

    private void findLatest10ProjectsEx9() {
        List<Project> projects = entityManager
                .createQuery("SELECT p FROM Project p " +
                "ORDER BY p.name ASC, p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();

        projects.forEach(project -> {
            System.out.printf("Project name: %s%n" +
                    "\tProject Description: %s%n" +
                    "\tProject Start Date: %s%n" +
                    " \tProject End Date: %s%n",
            project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate());
        });

    }

    private void getEmployeeWithProjectsEx8() throws IOException {
        System.out.println("Please enter valid employee Id: ");
        int id = Integer.parseInt(reader.readLine());

        Employee employee = entityManager.find(Employee.class, id);

        System.out.printf("%s %s - %s%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());

        employee.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> {
                    System.out.printf("\t%s%n", project.getName());
                });
    }

    private void addressesWithEmployeeCountEx7() {
        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a " +
                        "ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();

        addresses.forEach(address -> {
            System.out.printf("%s, %s - %d%n",
                    address.getText(), address.getTown().getName(),
                    address.getEmployees().size());
        });
    }

    private void addingNewAddressEx6() throws IOException {
        Address address = createAddress("Vitoshka 15");

        System.out.println("Please enter the employee last name");
        String lastName = reader.readLine();

        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.lastName= :last_name", Employee.class)
                .setParameter("last_name", lastName)
                .getSingleResult();

        Employee employee = entityManager
                .find(Employee.class, 291);

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();

    }

    private Address createAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        return address;
    }

    private void employeesFromDepartmentEx5() {
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name = 'Research and Development' " +
                        "ORDER BY e.salary, e.id", Employee.class)
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s from from Research and Development - $%.2f%n",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getSalary());
                });
        //Diane Margheim from Research and Development - $40900.00
    }

    private void employeesWithSalaryOver50000Ex4() {
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.salary > 50000", Employee.class)
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);

    }

    private void containsEmployeeEx3() throws IOException {
        System.out.println("Please enter employee full name: ");
        String fullName = reader.readLine();

        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE concat(e.firstName, ' ', e.lastName) = :name", Employee.class)
                .setParameter("name", fullName)
                .getResultList();
        System.out.println(employees.size() == 0 ? "No" : "Yes");
    }

    private void changeCasingEx2() {
        //JPQL for the query
        List<Town> towns = entityManager
                .createQuery("SELECT t FROM Town t " +
                        "WHERE length(t.name) <= 5", Town.class)
                .getResultList();

        entityManager.getTransaction().begin();
        towns.forEach(entityManager::detach);

        for (Town town : towns) {
            town.setName(town.getName().toLowerCase());
        }

        towns.forEach(entityManager::merge);
        entityManager.flush();
        entityManager.getTransaction().commit();

    }
}
