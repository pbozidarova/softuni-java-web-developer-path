package xml_exercise.models.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SuppliersViewRootDto {

    @XmlElement(name = "supplier")
    List<SuppliersViewDto> suppliers;

    public SuppliersViewRootDto() {
    }

    public List<SuppliersViewDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SuppliersViewDto> suppliers) {
        this.suppliers = suppliers;
    }
}
