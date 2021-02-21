package softuni.workshop.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
public class Company extends BaseEntity {

    private String name;
    private Set<Project> projects;

    public Company() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    @OneToMany(mappedBy = "company")
    public Set<Project> getProjects() {
        return projects;
    }

    public Company setProjects(Set<Project> projects) {
        this.projects = projects;
        return this;
    }
}
