package spring.data.jsonprocessing.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.data.jsonprocessing.constant.GlobalConstants;
import spring.data.jsonprocessing.model.dto.CategorySeedDto;
import spring.data.jsonprocessing.model.dto.ProductInRangeDto;
import spring.data.jsonprocessing.model.dto.ProductSeedDto;
import spring.data.jsonprocessing.model.dto.UserSeedDto;
import spring.data.jsonprocessing.service.CategoryService;
import spring.data.jsonprocessing.service.ProductService;
import spring.data.jsonprocessing.service.UserService;
import spring.data.jsonprocessing.util.FileIOUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class AppController implements CommandLineRunner {

    private final Gson gson;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final FileIOUtil fileIOUtil;

    @Autowired
    public AppController(Gson gson, CategoryService categoryService, UserService userService, ProductService productService, FileIOUtil fileIOUtil) {
        this.gson = gson;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.fileIOUtil = fileIOUtil;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedCategories();
        this.seedUsers();
        this.seedProducts();
        
        this.writeProductInRange();
    }

    private void writeProductInRange() throws IOException {
        List<ProductInRangeDto> dtos =
                this.productService.getAllProductsInRange();

        String jsons = this.gson.toJson(dtos);

        this.fileIOUtil.write(jsons, GlobalConstants.OUTPUT_EX1_FILE_PATH);


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
