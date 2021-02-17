package spring.data.jsonprocessing.model.dto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public class ProductSeedDto {
    @Expose
    @Length(min = 3, message = "The product name is not valid!")
    private String name;
    @Expose
    private BigDecimal price;

    public ProductSeedDto() {
    }

    public String getName() {
        return name;
    }

    public ProductSeedDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductSeedDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
