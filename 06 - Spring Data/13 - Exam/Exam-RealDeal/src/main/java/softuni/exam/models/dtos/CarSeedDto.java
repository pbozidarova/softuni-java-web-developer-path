package softuni.exam.models.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

public class CarSeedDto {
    @Expose
    private Integer kilometers;
    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private String registeredOn;

    public CarSeedDto() {
    }

    @Min(value = 1)
    @NotNull
    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }
    @Length(min = 2, max = 20)
    @NotNull
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
    @Length(min = 2, max = 20)
    @NotNull
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @NotNull
    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
    }
}
