package com.prep.model.binding;

import com.prep.model.entity.CategoryName;
import com.prep.model.service.ProductServiceModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBM {
    private String name;
    private String description;
    private LocalDateTime neededBefore;
    private BigDecimal price;
    private CategoryName category;

    public ProductAddBM() {
    }
    @NotBlank(message = "Name cannot be empty string")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters.")
    public String getName() {
        return name;
    }

    public ProductAddBM setName(String name) {
        this.name = name;
        return this;
    }
    @NotBlank(message = "Username cannot be empty string")
    @Size(min = 5, message = "Description must be min 5 characters.")
    public String getDescription() {
        return description;
    }

    public ProductAddBM setDescription(String description) {
        this.description = description;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-d'T'HH:mm")
    @FutureOrPresent(message = "The date cannot be in the past")
    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBM setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    @DecimalMin(value = "0", message = "The price must be positive!")
    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBM setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    @NotNull(message = "You must select the category!")
    public CategoryName getCategory() {
        return category;
    }

    public ProductAddBM setCategory(CategoryName category) {
        this.category = category;
        return this;
    }


}
