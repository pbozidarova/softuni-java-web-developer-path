package enities.university;

import enities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {

     private String email;
     private double salaryPerHour;

     private Set<Course> courses;

    public Teacher() {
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public Teacher setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "salary_per_hour")
    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public Teacher setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
        return this;
    }

    @OneToMany(mappedBy = "teacher", targetEntity = Course.class)
    public Set<Course> getCourses() {
        return courses;
    }

    public Teacher setCourses(Set<Course> courses) {
        this.courses = courses;
        return this;
    }
}
