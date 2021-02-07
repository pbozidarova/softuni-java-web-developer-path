package enities.football;

import enities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="countries")
public class Country {

    private String id;
    private String name;
    private Set<Continent> continents;
    private Set<Town> towns;

    public Country() {
    }
    @Id
    @Column(length = 3)
    public String getId() {
        return id;
    }

    public Country setId(String id) {
        this.id = id;
        return this;
    }

    @Column(name = "name", unique = true, length = 30, nullable = false)
    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }
    @ManyToMany
    @JoinTable(name = "countries_continents",
            joinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "continent_id", referencedColumnName = "id"))
    public Set<Continent> getContinents() {
        return continents;
    }

    public Country setContinents(Set<Continent> continents) {
        this.continents = continents;
        return this;
    }

    @OneToMany(mappedBy = "country")
    public Set<Town> getTowns() {
        return towns;
    }

    public Country setTowns(Set<Town> towns) {
        this.towns = towns;
        return this;
    }
}
