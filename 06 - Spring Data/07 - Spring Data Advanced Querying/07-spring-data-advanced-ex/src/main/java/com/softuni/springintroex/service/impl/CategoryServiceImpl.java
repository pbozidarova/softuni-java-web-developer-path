package com.softuni.springintroex.service.impl;

import com.softuni.springintroex.domain.entities.Category;
import com.softuni.springintroex.domain.repository.CategoryRepository;
import com.softuni.springintroex.service.CategoryService;
import com.softuni.springintroex.utils.FileUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.softuni.springintroex.constants.GlobalConstants.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final FileUtil fileUtil;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(FileUtil fileUtil, CategoryRepository categoryRepository) {
        this.fileUtil = fileUtil;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategoriesInDb() throws IOException {
        //seed categories.txt
        String[] lines = fileUtil.readFileContent(CATEGORIES_FILE_PATH);
        //new Category()
        for (String line : lines) {
            Category category = new Category(line);
            //save in db
            this.categoryRepository.saveAndFlush(category);
        }

    }
}
