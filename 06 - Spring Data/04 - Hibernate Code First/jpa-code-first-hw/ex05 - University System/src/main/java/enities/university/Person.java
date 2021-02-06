package enities.university;

import enities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;
    private int phoneNumber;

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    @Column(name = "phone_number")
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public Person setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
