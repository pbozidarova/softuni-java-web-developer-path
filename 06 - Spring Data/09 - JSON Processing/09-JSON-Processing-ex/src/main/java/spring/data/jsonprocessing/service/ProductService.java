package spring.data.jsonprocessing.service;

import spring.data.jsonprocessing.model.dto.ProductSeedDto;

public interface ProductService {
    void seedProducts(ProductSeedDto[] productSeedDtos );
}
