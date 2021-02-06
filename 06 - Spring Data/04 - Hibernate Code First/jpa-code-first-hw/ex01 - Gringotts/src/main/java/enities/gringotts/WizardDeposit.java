package enities.gringotts;

import enities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposit extends BaseEntity {

    private String firstName;// – Text field with max length of 50 symbols.
    private String lastName;// - Text field with max length of 60 symbols. Required
    private String notes;// – Text field with max length of 1000 symbols
    private int age;// – Non-negative number. Required
    private String magicWandCreator;// – Text field with max length of 100 symbols
    private int magicWandSize;// – Number in range [1, 215-1]
    private String depositGroup;// - Text field with max length of 20 symbols
    private LocalDateTime depositStartDate;// – Date and time field
    private BigDecimal depositAmount;// – Floating point number field
    private double depositInterest;// - Floating point number field
    private double depositCharge;// - Floating point number field
    private LocalDateTime depositExpirationDate;// – Date and time field
    private Boolean is_deposit_expired; // – Boolean field

    public WizardDeposit() {
    }

    @Column(name ="first_name", length = 50)
    public String getFirstName() {
        return firstName;
    }

    public WizardDeposit setFirstName(String first_name) {
        this.firstName = first_name;
        return this;
    }

    @Column(name ="last_name", length = 60, nullable = false)
    public String getLastName() {
        return lastName;
    }

    public WizardDeposit setLastName(String last_name) {
        this.lastName = last_name;
        return this;
    }
    @Column(name = "notes", length = 1000)
    public String getNotes() {
        return notes;
    }

    public WizardDeposit setNotes(String notes) {
        this.notes = notes;
        return this;
    }
    @Column(name ="age", columnDefinition = "INT UNSIGNED", nullable = false)
    public int getAge() {
        return age;
    }

    public WizardDeposit setAge(int age) {
        this.age = age;
        return this;
    }
    @Column(name ="magic_wand_creator", length = 100)
    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public WizardDeposit setMagicWandCreator(String magic_wand_creator) {
        this.magicWandCreator = magic_wand_creator;
        return this;
    }
    @Column(name = "magic_wand_size")
    public int getMagicWandSize() {
        return magicWandSize;
    }

    public WizardDeposit setMagicWandSize(int magic_wand_size) {
        this.magicWandSize = magic_wand_size;
        return this;
    }
    @Column(name = "deposit_group", length = 20)
    public String getDepositGroup() {
        return depositGroup;
    }

    public WizardDeposit setDepositGroup(String deposit_group) {
        this.depositGroup = deposit_group;
        return this;
    }

    @Column(name = "deposit_start_date")
    public LocalDateTime getDepositStartDate() {
        return depositStartDate;
    }

    public WizardDeposit setDepositStartDate(LocalDateTime deposit_start_date) {
        this.depositStartDate = deposit_start_date;
        return this;
    }

    @Column(name = "deposit_amount")
    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public WizardDeposit setDepositAmount(BigDecimal deposit_amount) {
        this.depositAmount = deposit_amount;
        return this;
    }
    @Column(name = "deposit_interest")
    public double getDepositInterest() {
        return depositInterest;
    }

    public WizardDeposit setDepositInterest(double deposit_interest) {
        this.depositInterest = deposit_interest;
        return this;
    }

    @Column(name = "deposit_charge")
    public double getDepositCharge() {
        return depositCharge;
    }

    public WizardDeposit setDepositCharge(double deposit_charge) {
        this.depositCharge = deposit_charge;
        return this;
    }

    @Column(name = "deposit_expiration_date")
    public LocalDateTime getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public WizardDeposit setDepositExpirationDate(LocalDateTime depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
        return this;
    }

    @Column(name = "is_deposit_expired")
    public Boolean getIs_deposit_expired() {
        return is_deposit_expired;
    }

    public WizardDeposit setIs_deposit_expired(Boolean is_deposit_expired) {
        this.is_deposit_expired = is_deposit_expired;
        return this;
    }
}
