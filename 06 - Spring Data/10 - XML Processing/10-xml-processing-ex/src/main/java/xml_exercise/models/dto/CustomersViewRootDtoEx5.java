package xml_exercise.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersViewRootDtoEx5 {

    @XmlElement
    List<CustomerViewDtoEx5> customers;

    public CustomersViewRootDtoEx5() {
    }

    public List<CustomerViewDtoEx5> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerViewDtoEx5> customers) {
        this.customers = customers;
    }
}
