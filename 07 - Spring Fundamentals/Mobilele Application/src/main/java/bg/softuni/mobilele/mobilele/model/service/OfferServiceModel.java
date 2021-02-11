package bg.softuni.mobilele.mobilele.model.service;


import bg.softuni.mobilele.mobilele.enums.EngineEnum;
import bg.softuni.mobilele.mobilele.model.validation.YearInPastOrPresent;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class OfferServiceModel {

    @NotNull
    private EngineEnum engine;
    @NotNull
    private String imageUrl;
    @NotNull
    @Positive
    private Integer mileage;
    @DecimalMin("100")
    private BigDecimal price;
    @YearInPastOrPresent(minYear = 1930)
    private Integer year;
    @NotEmpty
    @Size(min = 10, max = 512)
    private String description;
    @NotNull
    private String transmission;
    @NotNull
    private long modelId;

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferServiceModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferServiceModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public OfferServiceModel setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public Long getModelId() {
        return modelId;
    }

    public OfferServiceModel setModelId(long modelId) {
        this.modelId = modelId;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OfferServiceModel{");
        sb.append("engine=").append(engine);
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append(", mileage=").append(mileage);
        sb.append(", price=").append(price);
        sb.append(", year=").append(year);
        sb.append(", description='").append(description).append('\'');
        sb.append(", transmission='").append(transmission).append('\'');
        sb.append(", modelId=").append(modelId);
        sb.append('}');
        return sb.toString();
    }
}
