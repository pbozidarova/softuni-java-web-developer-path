package enities.hospital;

import enities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {

    private String diagnoseName;
    private String comments;

    private Set<Patient> patients;

    public Diagnose() {
    }

    @Column(name="diagnose_name")
    public String getDiagnoseName() {
        return diagnoseName;
    }

    public Diagnose setDiagnoseName(String diagnoseName) {
        this.diagnoseName = diagnoseName;
        return this;
    }

    @Column(name="comments")
    public String getComments() {
        return comments;
    }

    public Diagnose setComments(String comments) {
        this.comments = comments;
        return this;
    }

    @ManyToMany(mappedBy = "diagnoses", targetEntity = Patient.class)
    public Set<Patient> getPatients() {
        return patients;
    }

    public Diagnose setPatients(Set<Patient> patients) {
        this.patients = patients;
        return this;
    }
}
