package spring.data.jsonprocessing.model.dto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

public class UserSeedDto {
    @Expose
    private String firstName;
    @Expose
    @Length(min = 3, message = "Lastname is not valid!")
    private String lastName;
    @Expose
    private int age;

    public UserSeedDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserSeedDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserSeedDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserSeedDto setAge(int age) {
        this.age = age;
        return this;
    }
}
