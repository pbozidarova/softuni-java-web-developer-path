package softuni.workshop.service.services;

import javax.xml.bind.JAXBException;

public interface CompanyService {

    void importCompanies() throws JAXBException;

    boolean areImported();

    String readCompaniesXmlFile();
}
