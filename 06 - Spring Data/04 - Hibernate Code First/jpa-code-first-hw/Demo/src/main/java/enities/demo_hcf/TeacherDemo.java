package enities.demo_hcf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class TeacherDemo extends PersonDemo {

    private String speciality;

    public TeacherDemo() {
    }

    @Column(name = "speciality")
    public String getSpeciality() {
        return speciality;
    }

    public TeacherDemo setSpeciality(String speciality) {
        this.speciality = speciality;
        return this;
    }

}
