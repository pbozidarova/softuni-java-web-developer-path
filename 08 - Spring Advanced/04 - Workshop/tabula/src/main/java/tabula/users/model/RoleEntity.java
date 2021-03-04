package tabula.users.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "role", nullable = false)
    private String role;

    public RoleEntity setId(long id) {
        this.id = id;
        return this;
    }

    public RoleEntity setRole(String role) {
        this.role = role;
        return this;
    }
}
