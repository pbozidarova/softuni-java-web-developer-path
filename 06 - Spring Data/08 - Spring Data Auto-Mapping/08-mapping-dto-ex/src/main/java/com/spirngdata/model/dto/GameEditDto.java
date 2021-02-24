package com.spirngdata.model.dto;

import com.spirngdata.model.entity.BaseEntity;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GameEditDto extends BaseEntity {
    public String title;
    public BigDecimal price;
    public Double size;
    public String trailer;
    public String image;
    public String description;
    public LocalDate date;

    public GameEditDto()  {
    }

    @Pattern(regexp = "^[A-Z].{3,10}", message = "Title is not valid.")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DecimalMin(value = "0", message = "Price cannot be negative!")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Min(value = 0, message = "Size cannot be negative")
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Size(min = 11, max = 11, message = "The trailer is not valid!")
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
    @Pattern(regexp = "^http:\\/\\/.+|https:\\/\\/.+", message = "Image not valid!")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Size(min = 20, message = "Description is not valid!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
