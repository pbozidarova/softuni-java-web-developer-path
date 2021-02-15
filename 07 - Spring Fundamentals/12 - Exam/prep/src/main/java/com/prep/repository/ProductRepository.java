package com.prep.repository;

import com.prep.model.entity.CategoryName;
import com.prep.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT SUM(p.price) FROM Product p ")
    BigDecimal findTotalProductsSum();

    List<Product> findAllByCategory_Name(CategoryName categoryName);

}
