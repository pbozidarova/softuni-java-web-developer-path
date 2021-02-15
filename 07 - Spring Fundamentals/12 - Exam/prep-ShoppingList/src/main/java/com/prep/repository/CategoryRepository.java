package com.prep.repository;

import com.prep.model.entity.Category;
import com.prep.model.entity.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByName(CategoryName name);
}
