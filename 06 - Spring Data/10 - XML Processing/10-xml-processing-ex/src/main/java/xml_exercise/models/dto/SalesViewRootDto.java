package xml_exercise.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesViewRootDto {

    @XmlElement(name = "sale")
    List<SalesViewDto> sales;

    public SalesViewRootDto() {
    }

    public List<SalesViewDto> getSales() {
        return sales;
    }

    public void setSales(List<SalesViewDto> sales) {
        this.sales = sales;
    }
}
