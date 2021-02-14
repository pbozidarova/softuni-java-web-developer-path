package com.prep.model.service.impl;

import com.prep.model.entity.Category;
import com.prep.model.entity.CategoryName;
import com.prep.model.repository.CategoryRepository;
import com.prep.model.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if(this.categoryRepository.count() == 0){
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                                Category category =
                                        new Category(categoryName, "Description for " + categoryName.name());

                                categoryRepository.save(category);
                            }
                    );
        }
    }
}
