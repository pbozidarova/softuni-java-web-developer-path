package enities.hospital;

import enities.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity {

    private LocalDateTime visitationDate;
    private String comments;

    private Patient patient;

    public Visitation() {
    }

    @Column(name="visitation_date")
    public LocalDateTime getVisitationDate() {
        return visitationDate;
    }

    public Visitation setVisitationDate(LocalDateTime date) {
        this.visitationDate = date;
        return this;
    }

    @Column(name = "comment")
    public String getComments() {
        return comments;
    }

    public Visitation setComments(String comment) {
        this.comments = comment;
        return this;
    }

    @ManyToOne
    @JoinColumn(name="patient_id", referencedColumnName = "id")
    public Patient getPatient() {
        return patient;
    }

    public Visitation setPatient(Patient patient) {
        this.patient = patient;
        return this;
    }
}

