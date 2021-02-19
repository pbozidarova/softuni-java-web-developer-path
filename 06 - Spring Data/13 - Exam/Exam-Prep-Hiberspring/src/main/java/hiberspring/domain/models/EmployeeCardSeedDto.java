package hiberspring.domain.models;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class EmployeeCardSeedDto {
    @Expose
    private String number;

    public EmployeeCardSeedDto() {
    }

    @NotNull
    @Column(name = "number", unique = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
