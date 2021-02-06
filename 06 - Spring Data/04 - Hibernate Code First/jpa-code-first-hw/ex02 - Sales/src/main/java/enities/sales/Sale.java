package enities.sales;

import enities.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    private Product product;
    private Customer customer;
    private StoreLocation storeLocation;
    private LocalDateTime date;

    public Sale() {
    }

    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName = "id")
    public Product getProduct() {
        return product;
    }

    public Sale setProduct(Product product) {
        this.product = product;
        return this;
    }

    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName = "id")
    public Customer getCustomer() {
        return customer;
    }

    public Sale setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    @ManyToOne
    @JoinColumn(name="store_location_id", referencedColumnName = "id")
    public StoreLocation getStoreLocation() {
        return storeLocation;
    }

    public Sale setStoreLocation(StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Sale setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }
}
