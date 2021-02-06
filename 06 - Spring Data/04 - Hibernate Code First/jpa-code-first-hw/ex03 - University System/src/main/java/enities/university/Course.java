package enities.university;

import enities.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int credits;

    private Set<Student> students;
    private Teacher teacher;

    public Course() {
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Course setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Course setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public int getCredits() {
        return credits;
    }

    public Course setCredits(int credits) {
        this.credits = credits;
        return this;
    }

    @ManyToMany
    @JoinTable (name = "courses_students",
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
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    public Teacher getTeacher() {
        return teacher;
    }

    public Course setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }
}
