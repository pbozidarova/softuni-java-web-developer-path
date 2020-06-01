package wpartone.model.service;

import wpartone.service.RoleService;

public class RoleServiceModel extends BaseServiceModel {
    private String name;

    public RoleServiceModel(){

    }

    public String getName() {
        return name;
    }

    public RoleServiceModel setName(String name) {
        this.name = name;
        return this;
    }
}
