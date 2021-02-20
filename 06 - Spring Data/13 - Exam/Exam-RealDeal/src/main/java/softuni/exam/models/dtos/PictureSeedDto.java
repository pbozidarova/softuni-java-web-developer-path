package softuni.exam.models.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;
import softuni.exam.models.entities.Car;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PictureSeedDto {
    @Expose
    private String dateAndTime;
    @Expose
    private String name;
    @Expose
    private Long car;

    public PictureSeedDto() {
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
    @Column(unique = true)
    @Length(min = 2, max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NotNull
    public Long getCar() {
        return car;
    }

    public void setCar(Long car) {
        this.car = car;
    }
}
