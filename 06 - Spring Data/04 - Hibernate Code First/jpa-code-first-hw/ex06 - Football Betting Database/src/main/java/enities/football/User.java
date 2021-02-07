package enities.football;

import enities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name="users")
public class User extends BaseEntity {
    private String Username;
    private String Password;
    private String email;
    private String fullName;
    private BigDecimal balance;
    private Set<Bet> bets;

    public User() {
    }

    @Column(name = "username", length = 40, nullable = false)
    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    @Column(name = "password", length = 70, nullable = false)
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Column(name = "email", length = 70)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "full_name", length = 70)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "balance")
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @OneToMany(mappedBy = "user")
    public Set<Bet> getBets() {
        return bets;
    }

    public void setBets(Set<Bet> bets) {
        this.bets = bets;
    }
}
