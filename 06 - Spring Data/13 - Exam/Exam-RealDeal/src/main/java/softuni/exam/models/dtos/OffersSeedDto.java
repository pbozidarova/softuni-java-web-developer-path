package softuni.exam.models.dtos;

import org.hibernate.validator.constraints.Length;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Seller;

import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDate;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OffersSeedDto {
    @XmlElement
    private String description;
    @XmlElement
    private BigDecimal price;
    @XmlElement(name = "added-on")
    private String addedOn;
    @XmlElement(name = "has-gold-status")
    private Boolean hasGoldStatus;
    @XmlElement
    private OffersCarSeedDto car;
    @XmlElement
    private OffersSellerSeedDto seller;

    public OffersSeedDto() {
    }
    @Length(min = 5)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Min(value = 1)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public Boolean getHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(Boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public OffersCarSeedDto getCar() {
        return car;
    }

    public void setCar(OffersCarSeedDto car) {
        this.car = car;
    }

    public OffersSellerSeedDto getSeller() {
        return seller;
    }

    public void setSeller(OffersSellerSeedDto seller) {
        this.seller = seller;
    }
}
