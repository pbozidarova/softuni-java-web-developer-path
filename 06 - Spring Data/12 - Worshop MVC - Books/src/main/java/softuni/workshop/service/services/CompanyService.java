package softuni.workshop.service.services;

import softuni.workshop.web.models.CompanyViewModel;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface CompanyService {

    void importCompanies() throws JAXBException;

    boolean areImported();

    String readCompaniesXmlFile();

    List<CompanyViewModel> findAll();

    String companiesToJson();
}
