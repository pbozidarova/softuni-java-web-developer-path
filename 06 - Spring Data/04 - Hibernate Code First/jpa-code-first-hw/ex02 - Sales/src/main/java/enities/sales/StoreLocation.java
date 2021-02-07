package enities.sales;

import enities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "store_locations")
public class StoreLocation extends BaseEntity {

   private String locationName;
   private Set<Sale> sales;

    public StoreLocation() {
    }

    @Column(name = "location_name")
    public String getLocationName() {
        return locationName;
    }

    public StoreLocation setLocationName(String locationName) {
        this.locationName = locationName;
        return this;
    }

    @OneToMany(mappedBy = "storeLocation", targetEntity = Sale.class)
    public Set<Sale> getSales() {
        return sales;
    }

    public StoreLocation setSales(Set<Sale> sales) {
        this.sales = sales;
        return this;
    }
}
