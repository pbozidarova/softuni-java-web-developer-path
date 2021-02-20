package softuni.workshop.data.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role extends BaseEntity implements GrantedAuthority {

    private String authority;

    public Role() {
    }

    @Override
    @Column(name="authority", unique = true, nullable = false)
    public String getAuthority() {
        return null;
    }

    public Role setAuthority(String authority) {
        this.authority = authority;
        return this;
    }
}
