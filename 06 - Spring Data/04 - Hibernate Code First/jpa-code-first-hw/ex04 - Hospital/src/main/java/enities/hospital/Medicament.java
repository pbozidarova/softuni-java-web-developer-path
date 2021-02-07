package enities.hospital;

import enities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="medicaments")
public class Medicament extends BaseEntity {
    private String medicamentName;

    private Set<Patient> patients;

    public Medicament() {
    }

    @Column(name="medicament_name")
    public String getMedicamentName() {
        return medicamentName;
    }

    public Medicament setMedicamentName(String medicamentName) {
        this.medicamentName = medicamentName;
        return this;
    }

    @ManyToMany(mappedBy = "medicaments", targetEntity = Patient.class)
    public Set<Patient> getPatients() {
        return patients;
    }

    public Medicament setPatients(Set<Patient> patients) {
        this.patients = patients;
        return this;
    }
}
