package bg.softuni.mobilele.mobilele.model.view;

import bg.softuni.mobilele.mobilele.enums.EngineEnum;
import bg.softuni.mobilele.mobilele.enums.TransmissionEnum;

import java.math.BigDecimal;

public class OfferSummeryViewModel {

    private EngineEnum engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private int year;
    private TransmissionEnum transmission;

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferSummeryViewModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummeryViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferSummeryViewModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferSummeryViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferSummeryViewModel setYear(int year) {
        this.year = year;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferSummeryViewModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }
}
