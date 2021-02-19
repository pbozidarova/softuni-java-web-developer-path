package hiberspring.domain.models;

import hiberspring.domain.entities.Branch;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSeedRootDto {
    @XmlElement(name = "product")
    List<ProductSeedDto> productSeedDtos;

    public ProductSeedRootDto() {
    }
    @NotNull
    public List<ProductSeedDto> getProductSeedDtos() {
        return productSeedDtos;
    }

    public void setProductSeedDtos(List<ProductSeedDto> productSeedDtos) {
        this.productSeedDtos = productSeedDtos;
    }
}
