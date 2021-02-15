package com.prep.service;


import com.prep.model.entity.CategoryName;
import com.prep.model.entity.Product;
import com.prep.model.service.ProductServiceModel;
import com.prep.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryName categoryName);

}
