package hiberspring.domain.models;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

public class TownForBranchesSeedDto {
    @Expose
    private String name;

    public TownForBranchesSeedDto() {
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
