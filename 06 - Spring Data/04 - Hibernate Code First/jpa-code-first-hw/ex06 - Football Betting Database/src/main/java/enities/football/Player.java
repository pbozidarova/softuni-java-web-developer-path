package enities.football;

import enities.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="colors")
public class Player extends BaseEntity {

    private String name;
    private int squadNumber;
    private Team team;
    private Position position;
    private boolean isCurrentlyInjured;

    public String getName() {
        return name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name="squad_number")
    public int getSquadNumber() {
        return squadNumber;
    }

    public Player setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
        return this;
    }

    @ManyToOne
    @JoinColumn(name="team_id", referencedColumnName = "id")
    public Team getTeam() {
        return team;
    }

    public Player setTeam(Team team) {
        this.team = team;
        return this;
    }

    @ManyToOne
    @JoinColumn(name="position_id", referencedColumnName = "id")
    public Position getPosition() {
        return position;
    }

    public Player setPosition(Position position) {
        this.position = position;
        return this;
    }

    @Column(name="is_currently_injured")
    public boolean isCurrentlyInjured() {
        return isCurrentlyInjured;
    }

    public Player setCurrentlyInjured(boolean currentlyInjured) {
        isCurrentlyInjured = currentlyInjured;
        return this;
    }
}
