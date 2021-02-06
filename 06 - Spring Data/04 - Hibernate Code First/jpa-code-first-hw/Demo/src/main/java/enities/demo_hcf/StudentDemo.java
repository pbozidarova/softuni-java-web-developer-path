package enities.demo_hcf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "students")
public class StudentDemo extends PersonDemo {

    private double grade;
    private Set<CourseDemo> courses;

    public StudentDemo() {
    }

    @Column(name = "grade")
    public double getGrade() {
        return grade;
    }

    public StudentDemo setGrade(double grade) {
        this.grade = grade;
        return this;
    }

    @ManyToMany(mappedBy = "students", targetEntity = CourseDemo.class)
    public Set<CourseDemo> getCourses() {
        return courses;
    }

    public StudentDemo setCourses(Set<CourseDemo> courses) {
        this.courses = courses;
        return this;
    }
}
