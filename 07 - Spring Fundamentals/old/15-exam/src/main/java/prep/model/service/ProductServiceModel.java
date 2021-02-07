package prep.model.service;

import prep.model.entity.Category;

import java.math.BigDecimal;

public class ProductServiceModel extends BaseServiceModel{
    private String name;
    private String description;
    private BigDecimal price;
    private String neededBefore;
    private CategoryServiceModel category;

    public ProductServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(String neededBefore) {
        this.neededBefore = neededBefore;
    }

    public CategoryServiceModel getCategory() {
        return category;
    }

    public void setCategory(CategoryServiceModel category) {
        this.category = category;
    }
}
