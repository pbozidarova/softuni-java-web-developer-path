package spring.data.jsonprocessing.model.dto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

public class CategorySeedDto {

    @Expose
    @Length(min = 3, max = 11, message = "Wrong category name!")
    private String name;

    public CategorySeedDto(String name) {
    }

    public String getName() {
        return name;
    }

    public CategorySeedDto setName(String name) {
        this.name = name;
        return this;
    }
}
