package enities.payments;

import javax.persistence.*;

@Entity
@Table(name="bank_accounts")
public class BankAccount extends BillingDetail {
    private String bankName;
    private String SWIFTCode;

    private User user;

    public BankAccount() {
    }

    @Column(name="bank_name")
    public String getBankName() {
        return bankName;
    }

    public BankAccount setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    @Column(name="SWIFT_code")
    public String getSWIFTCode() {
        return SWIFTCode;
    }

    public BankAccount setSWIFTCode(String SWIFTCode) {
        this.SWIFTCode = SWIFTCode;
        return this;
    }

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public BankAccount setUser(User user) {
        this.user = user;
        return this;
    }
}
