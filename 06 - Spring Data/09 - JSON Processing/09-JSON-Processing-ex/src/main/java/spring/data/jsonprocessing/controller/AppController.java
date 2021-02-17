package spring.data.jsonprocessing.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.data.jsonprocessing.constant.GlobalConstants;
import spring.data.jsonprocessing.model.dto.CategorySeedDto;
import spring.data.jsonprocessing.model.dto.ProductSeedDto;
import spring.data.jsonprocessing.model.dto.UserSeedDto;
import spring.data.jsonprocessing.service.CategoryService;
import spring.data.jsonprocessing.service.ProductService;
import spring.data.jsonprocessing.service.UserService;

import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class AppController implements CommandLineRunner {

    private final Gson gson;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    
    @Autowired
    public AppController(Gson gson, CategoryService categoryService, UserService userService, ProductService productService) {
        this.gson = gson;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedCategories();
        this.seedUsers();
        this.seedProducts();
    }

    private void seedProducts() throws FileNotFoundException {
        ProductSeedDto[] dtos =
                this.gson.fromJson(new FileReader(GlobalConstants.PRODUCTS_FILE_PATH), ProductSeedDto[].class);

        this.productService.seedProducts(dtos);
    }

    private void seedUsers() throws FileNotFoundException {
        UserSeedDto[] dtos =
                this.gson.fromJson(new FileReader(GlobalConstants.USERS_FILE_PATH), UserSeedDto[].class);

        this.userService.seedUsers(dtos);
    }

    private void seedCategories() throws FileNotFoundException {

        CategorySeedDto[] dtos =
                this.gson.fromJson(new FileReader(GlobalConstants.CATEGORY_FILE_PATH), CategorySeedDto[].class);

        this.categoryService.seedCategories(dtos);
    }
}