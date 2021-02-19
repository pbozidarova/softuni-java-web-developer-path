package softuni.exam.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    private String url;
    //private List<Team> teams;

    public Picture() {
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

/*    @OneToMany(mappedBy = "picture",targetEntity = Team.class)
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }*/
}
