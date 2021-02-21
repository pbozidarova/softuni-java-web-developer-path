package softuni.workshop.data.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectDto {

    @XmlElement
    private String name;

    @XmlElement
    private String description;

    @XmlElement(name="start-date")
    private String startDate;

    @XmlElement(name="is-finished")
    private boolean isFinished;

    @XmlElement
    private BigDecimal payment;

    @XmlElement(name="company")
    private CompanyDto companyDto;

    public ProjectDto() {
    }

    public String getName() {
        return name;
    }

    public ProjectDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProjectDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public ProjectDto setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public ProjectDto setFinished(boolean finished) {
        isFinished = finished;
        return this;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public ProjectDto setPayment(BigDecimal payment) {
        this.payment = payment;
        return this;
    }

    public CompanyDto getCompanyDto() {
        return companyDto;
    }

    public ProjectDto setCompanyDto(CompanyDto companyDto) {
        this.companyDto = companyDto;
        return this;
    }
}
