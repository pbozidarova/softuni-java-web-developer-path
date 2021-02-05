package enities.demo_hcf;

import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Person {

    private double grade;
    private Set<Course> courses;

    public Student() {
    }

    @Column(name = "grade")
    public double getGrade() {
        return grade;
    }

    public Student setGrade(double grade) {
        this.grade = grade;
        return this;
    }

    @ManyToMany(mappedBy = "students", targetEntity = Course.class)
    public Set<Course> getCourses() {
        return courses;
    }

    public Student setCourses(Set<Course> courses) {
        this.courses = courses;
        return this;
    }
}
