package softuni.workshop.web.models;

import java.math.BigDecimal;

public class ProjectViewModel {
    private String name;
    private String description;
    private BigDecimal payment;

    public ProjectViewModel() {
    }

    public String getName() {
        return name;
    }

    public ProjectViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProjectViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public ProjectViewModel setPayment(BigDecimal payment) {
        this.payment = payment;
        return this;
    }
}
