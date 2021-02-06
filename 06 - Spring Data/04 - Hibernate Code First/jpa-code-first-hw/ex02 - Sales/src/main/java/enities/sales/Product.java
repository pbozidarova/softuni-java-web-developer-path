package enities.sales;

import enities.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
   private String name;
    private Double quantity;
    private BigDecimal price;
    private Set<Sale> sales;

    public Product() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }
    @Column(name = "quantity")
    public Double getQuantity() {
        return quantity;
    }

    public Product setQuantity(Double quantity) {
        this.quantity = quantity;
        return this;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @OneToMany(mappedBy = "product", targetEntity = Sale.class)
    public Set<Sale> getSales() {
        return sales;
    }

    public Product setSales(Set<Sale> sales) {
        this.sales = sales;
        return this;
    }
}
