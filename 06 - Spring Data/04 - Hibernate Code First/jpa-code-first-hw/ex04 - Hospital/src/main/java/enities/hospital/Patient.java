package enities.hospital;

import enities.BaseEntity;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private LocalDateTime dateOfBirth;
    private Blob picture;
    private Boolean isInsured;

    private Set<Visitation> visitations;
    private Set<Medicament> medicaments;
    private Set<Diagnose> diagnoses;

    public Patient() {
    }

    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    public Patient setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    public Patient setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    @Column(name="address")
    public String getAddress() {
        return address;
    }

    public Patient setAddress(String address) {
        this.address = address;
        return this;
    }
    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public Patient setEmail(String email) {
        this.email = email;
        return this;
    }
    @Column(name="date_of_birth")
    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public Patient setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @Column(name="picture")
    public Blob getPicture() {
        return picture;
    }

    public Patient setPicture(Blob picture) {
        this.picture = picture;
        return this;
    }

    @Column(name="is_insured")
    public Boolean getInsured() {
        return isInsured;
    }

    public Patient setInsured(Boolean insured) {
        isInsured = insured;
        return this;
    }

    @OneToMany(mappedBy = "patient", targetEntity = Visitation.class)
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public Patient setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
        return this;
    }

    @ManyToMany
    @JoinTable(name="patients_medicaments",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="medicaments_id", referencedColumnName = "id"))
    public Set<Medicament> getMedicaments() {
        return medicaments;
    }

    public Patient setMedicaments(Set<Medicament> medicaments) {
        this.medicaments = medicaments;
        return this;
    }

    @ManyToMany
    @JoinTable(name = "patients_diagnoses",
        joinColumns = @JoinColumn(name="patient_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="diagnoses_id", referencedColumnName = "id"))
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public Patient setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
        return this;
    }
}
