package enities.demo_hcf;

import enities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {
    private String name;
    private Set<Student> students;
    private Teacher teacher;

    public Course(){

    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToMany
    @JoinTable(name = "courses_students",
        joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    public Set<Student> getStudents() {
        return students;
    }

    public Course setStudents(Set<Student> students) {
        this.students = students;
        return this;
    }

    @ManyToOne
    @JoinColumn(name="teacher_id", referencedColumnName = "id")
    public Teacher getTeacher() {
        return teacher;
    }

    public Course setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }
}
