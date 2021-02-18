package xml_exercise.models.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarCarsPartsViewDto {

    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private Integer travelledDistance;

    @XmlElement(name = "part")
    List<CarPartsPartsViewDto> parts;

    public CarCarsPartsViewDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Integer travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public List<CarPartsPartsViewDto> getParts() {
        return parts;
    }

    public void setParts(List<CarPartsPartsViewDto> parts) {
        this.parts = parts;
    }
}
