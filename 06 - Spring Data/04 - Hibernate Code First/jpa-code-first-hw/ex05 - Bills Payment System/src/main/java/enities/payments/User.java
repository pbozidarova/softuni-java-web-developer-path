package enities.payments;

import enities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="users")
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private Set<CreditCard> creditCards;
    private Set<BankAccount> bankAccounts;

    public User() {
    }

    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @OneToMany(mappedBy = "user", targetEntity = CreditCard.class)
    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public User setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
        return this;
    }

    @OneToMany(mappedBy = "user", targetEntity = BankAccount.class)
    public Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public User setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
        return this;
    }
}
