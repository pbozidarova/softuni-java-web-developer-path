package spring.data.jsonprocessing.service;

import spring.data.jsonprocessing.model.dto.CategorySeedDto;
import spring.data.jsonprocessing.model.entity.Category;

import java.util.List;

public interface CategoryService {
    void seedCategories(CategorySeedDto[] categorySeedDtos);

    List<Category> getRandomCategories();
}
