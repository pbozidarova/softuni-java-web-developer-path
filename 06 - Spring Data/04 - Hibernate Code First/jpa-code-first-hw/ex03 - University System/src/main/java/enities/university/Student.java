package enities.university;

import enities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Person {

   private double averageGrade;
   private String attendance;

   private Set<Course> courses;

    public Student() {
    }


    @Column(name = "average_grade")
    public double getAverageGrade() {
        return averageGrade;
    }

    public Student setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
        return this;
    }
    @Column(name = "attendance")
    public String getAttendance() {
        return attendance;
    }

    public Student setAttendance(String attendance) {
        this.attendance = attendance;
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
