package softuni.workshop.service.models;

public class RoleServiceModel {
    private long id;
    private String authority;

    public RoleServiceModel() {
    }

    public long getId() {
        return id;
    }

    public RoleServiceModel setId(long id) {
        this.id = id;
        return this;
    }

    public String getAuthority() {
        return authority;
    }

    public RoleServiceModel setAuthority(String authority) {
        this.authority = authority;
        return this;
    }
}
