package enities.demo_hcf;

import enities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
public class CourseDemo extends BaseEntity {
    private String name;
    private Set<StudentDemo> students;
    private TeacherDemo teacher;

    public CourseDemo(){

    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public CourseDemo setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToMany
    @JoinTable(name = "courses_students",
        joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    public Set<StudentDemo> getStudents() {
        return students;
    }

    public CourseDemo setStudents(Set<StudentDemo> students) {
        this.students = students;
        return this;
    }

    @ManyToOne
    @JoinColumn(name="teacher_id", referencedColumnName = "id")
    public TeacherDemo getTeacher() {
        return teacher;
    }

    public CourseDemo setTeacher(TeacherDemo teacher) {
        this.teacher = teacher;
        return this;
    }
}
