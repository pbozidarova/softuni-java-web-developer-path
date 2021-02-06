package enities.payments;

import enities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BillingDetail extends BaseEntity {
    private String number;
    private String owner;

    public BillingDetail() {
    }

    @Column(name="number")
    public String getNumber() {
        return number;
    }

    public BillingDetail setNumber(String number) {
        this.number = number;
        return this;
    }

    @Column(name="owner")
    public String getOwner() {
        return owner;
    }

    public BillingDetail setOwner(String owner) {
        this.owner = owner;
        return this;
    }
}
