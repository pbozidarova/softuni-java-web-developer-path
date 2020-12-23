package prep.model.binding;

import org.hibernate.validator.constraints.Length;
import prep.model.entity.Category;
import prep.model.entity.CategoryName;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    private String name;
    private String description;
    private BigDecimal price;
    private String neededBefore;
    private CategoryName category;

    public ProductAddBindingModel() {
    }

    @Length(min = 3, max = 20, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20)." )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 5, message = "Description min length must be minimum 5(inclusive) characters" )
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "Category cannot be null.")
    public CategoryName getCategory() {
        return category;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }

    @Length(min = 2, message = "Date and Time, that cannot be in the past")
    public String getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(String neededBefore) {
        this.neededBefore = neededBefore;
    }

    @DecimalMin(value = "0", message = "o\tPrice must be a positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
