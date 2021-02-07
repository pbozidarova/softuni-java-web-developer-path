package enities.football;

import enities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="competitions")
public class Competition extends BaseEntity {
    private String name;
    private CompetitionType type;
    private Set<Game> games;

    public Competition() {
    }

    @Column(name = "name", length = 50, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "competition_type", referencedColumnName = "id")
    public CompetitionType getType() {
        return type;
    }

    public void setType(CompetitionType type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "competition")
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
