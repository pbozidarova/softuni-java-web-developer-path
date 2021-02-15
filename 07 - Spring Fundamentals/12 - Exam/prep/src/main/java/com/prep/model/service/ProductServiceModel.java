package com.prep.model.service;

import com.prep.model.entity.Category;
import com.prep.model.entity.CategoryName;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductServiceModel {

    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime NeededBefore;
    private CategoryName category;


    public ProductServiceModel() {
    }

    public String getName() {
        return name;
    }

    public ProductServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return NeededBefore;
    }

    public ProductServiceModel setNeededBefore(LocalDateTime neededBefore) {
        NeededBefore = neededBefore;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public ProductServiceModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }
}
