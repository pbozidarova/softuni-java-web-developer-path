package spring.data.jsonprocessing.model.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductInRangeDto {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String seller;

    public ProductInRangeDto() {
    }

    public String getName() {
        return name;
    }

    public ProductInRangeDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductInRangeDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getSeller() {
        return seller;
    }

    public ProductInRangeDto setSeller(String seller) {
        this.seller = seller;
        return this;
    }
}
