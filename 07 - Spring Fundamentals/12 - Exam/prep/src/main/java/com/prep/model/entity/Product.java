package com.prep.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="products")
public class Product extends BaseEntity {
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime NeededBefore;
    private Category category;

    public Product() {
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }
    @Column(columnDefinition = "text")
    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }
    @Column(name="price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(name="needed_before")
    public LocalDateTime getNeededBefore() {
        return NeededBefore;
    }

    public Product setNeededBefore(LocalDateTime neededBefore) {
        NeededBefore = neededBefore;
        return this;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }
}
