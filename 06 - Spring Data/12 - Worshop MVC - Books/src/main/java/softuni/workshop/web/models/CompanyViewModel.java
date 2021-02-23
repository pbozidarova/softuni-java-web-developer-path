package softuni.workshop.web.models;

import softuni.workshop.data.entities.Project;

import java.util.Set;

public class CompanyViewModel {

    private String name;


    public CompanyViewModel() {
    }

    public String getName() {
        return name;
    }

    public CompanyViewModel setName(String name) {
        this.name = name;
        return this;
    }


}
