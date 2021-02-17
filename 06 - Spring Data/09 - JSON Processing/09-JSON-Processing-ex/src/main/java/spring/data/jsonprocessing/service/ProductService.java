package spring.data.jsonprocessing.service;

import spring.data.jsonprocessing.model.dto.ProductInRangeDto;
import spring.data.jsonprocessing.model.dto.ProductSeedDto;
import spring.data.jsonprocessing.model.entity.Product;

import java.util.List;

public interface ProductService {
    void seedProducts(ProductSeedDto[] productSeedDtos );

    List<ProductInRangeDto> getAllProductsInRange();
}
