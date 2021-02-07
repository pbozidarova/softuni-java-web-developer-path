package enities.football;

import enities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="positions")
public class Position {

    private String id;
    private String positionDescription;
    private Set<Player> players;

    @Id
    @Column(name="id", length = 2)
    public String getId() {
        return id;
    }

    public Position setId(String id) {
        this.id = id;
        return this;
    }

    @Column(name = "position_description", length = 30, nullable = false)
    public String getPositionDescription() {
        return positionDescription;
    }

    public Position setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
        return this;
    }

    @OneToMany(mappedBy = "position")
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
