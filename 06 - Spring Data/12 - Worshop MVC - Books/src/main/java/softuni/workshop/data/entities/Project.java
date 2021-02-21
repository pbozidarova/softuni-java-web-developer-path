package softuni.workshop.data.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table
public class Project extends BaseEntity {

    private String name;
    private String description;
    private boolean isFinished;
    private BigDecimal payment;
    private String startDate;
    private Company company;
    private Set<Employee> employees;

    public Project() {
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(name="is_finished")
    public boolean isFinished() {
        return isFinished;
    }

    public Project setFinished(boolean finished) {
        isFinished = finished;
        return this;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public Project setPayment(BigDecimal payment) {
        this.payment = payment;
        return this;
    }

    @Column(name="start_date")
    public String getStartDate() {
        return startDate;
    }

    public Project setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    public Company getCompany() {
        return company;
    }

    public Project setCompany(Company company) {
        this.company = company;
        return this;
    }

    @OneToMany(mappedBy = "project")
    public Set<Employee> getEmployees() {
        return employees;
    }

    public Project setEmployees(Set<Employee> employees) {
        this.employees = employees;
        return this;
    }
}
