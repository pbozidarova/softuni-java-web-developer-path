package bg.softuni.mobilele.mobilele.model.view;

import bg.softuni.mobilele.mobilele.enums.ModelCategoryEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ModelViewModel {

    private String name;
    private ModelCategoryEnum category;
    private String imageUrl;
    private int startYear;
    private Integer endEYear;

    public String getName() {
        return name;
    }

    public ModelViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public ModelCategoryEnum getCategory() {
        return category;
    }

    public ModelViewModel setCategory(ModelCategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getStartYear() {
        return startYear;
    }

    public ModelViewModel setStartYear(int startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndEYear() {
        return endEYear;
    }

    public ModelViewModel setEndEYear(Integer endEYear) {
        this.endEYear = endEYear;
        return this;
    }

    @Override
    public String toString() {
        return "ModelViewModel{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endEYear=" + endEYear +
                '}';
    }
}
