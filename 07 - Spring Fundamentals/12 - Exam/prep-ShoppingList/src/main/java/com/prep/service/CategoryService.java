package com.prep.service;

import com.prep.model.entity.Category;
import com.prep.model.entity.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryName categoryName);
}
