package spring.data.jsonprocessing.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.data.jsonprocessing.constant.GlobalConstants;
import spring.data.jsonprocessing.model.dto.CategorySeedDto;

import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class AppController implements CommandLineRunner {

    private final Gson gson;

    @Autowired
    public AppController(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedCategories();
    }

    private void seedCategories() throws FileNotFoundException {

        CategorySeedDto[] dtos =
                this.gson.fromJson(new FileReader(GlobalConstants.CATEGORY_FILE_PATH), CategorySeedDto[].class);

        System.out.println();
    }
}
