package xml_exercise.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarPartsViewRootDto {

    @XmlElement(name = "car")
    List<CarCarsPartsViewDto> cars;

    public CarPartsViewRootDto() {
    }

    public List<CarCarsPartsViewDto> getCars() {
        return cars;
    }

    public void setCars(List<CarCarsPartsViewDto> cars) {
        this.cars = cars;
    }
}
