package enities.football;

import enities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="continents")
public class Continent extends BaseEntity {
    private String name;
    private Set<Country> countries;

    public Continent() {
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public Continent setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToMany(mappedBy = "continents")
    public Set<Country> getCountries() {
        return countries;
    }

    public Continent setCountries(Set<Country> countries) {
        this.countries = countries;
        return this;
    }
}
