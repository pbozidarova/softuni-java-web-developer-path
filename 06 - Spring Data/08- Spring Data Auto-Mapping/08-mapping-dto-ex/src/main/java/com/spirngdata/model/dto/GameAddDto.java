package com.spirngdata.model.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GameAddDto {
    private String title;
    private BigDecimal price;
    private double size;
    private String trailer;
    private String imageUrl;
    private String description;
    private LocalDate releaseDate;

    public GameAddDto() {
    }

    public GameAddDto(String title, BigDecimal price, double size, String trailer, String imageUrl, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.imageUrl = imageUrl;
        this.description = description;
        this.releaseDate = releaseDate;
    }
    @Pattern(regexp = "^[A-Z][a-z]{2,100}", message = "Please enter valid title!")
    public String getTitle() {
        return title;
    }

    public GameAddDto setTitle(String title) {
        this.title = title;
        return this;
    }
    @DecimalMin(value = "0", message = "The price must be positive!")
    public BigDecimal getPrice() {
        return price;
    }

    public GameAddDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Min(value = 0, message = "The size must be positive!")
    public double getSize() {
        return size;
    }

    public GameAddDto setSize(double size) {
        this.size = size;
        return this;
    }
    @Size(min=11, max=11, message = "The trailer is not valid!")
    public String getTrailer() {
        return trailer;
    }

    public GameAddDto setTrailer(String trailer) {
        this.trailer = trailer;
        return this;
    }

    @Pattern(regexp = "^http:\\/\\/.+|https:\\/\\/.+", message = "Please enter valid image url!")
    public String getImageUrl() {
        return imageUrl;
    }

    public GameAddDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
    @Size(min = 20, message = "The description must be at least 20 symbols!")
    public String getDescription() {
        return description;
    }

    public GameAddDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public GameAddDto setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }
}

