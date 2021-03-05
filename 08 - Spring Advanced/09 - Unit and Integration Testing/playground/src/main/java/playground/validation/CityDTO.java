package playground.validation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

public class CityDTO {

    @NotEmpty
    public String name;

    private List<@Pattern(regexp="^\\d{4}$") String> postalCodes;

    public CityDTO() {
    }

    public String getName() {
        return name;
    }

    public CityDTO setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getPostalCodes() {
        return postalCodes;
    }

    public CityDTO setPostalCodes(List<String> postalCodes) {
        this.postalCodes = postalCodes;
        return this;
    }
}
