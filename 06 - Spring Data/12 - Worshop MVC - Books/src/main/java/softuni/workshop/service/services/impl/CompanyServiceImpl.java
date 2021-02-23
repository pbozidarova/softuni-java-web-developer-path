package softuni.workshop.service.services.impl;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.workshop.data.dto.CompanyDto;
import softuni.workshop.data.dto.CompanyRootDto;
import softuni.workshop.data.entities.Company;
import softuni.workshop.data.repositories.CompanyRepository;
import softuni.workshop.service.services.CompanyService;
import softuni.workshop.util.XmlParser;
import softuni.workshop.web.models.CompanyViewModel;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final String XML_PATH = "src/main/resources/files/xmls/companies.xml";
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, XmlParser xmlParser, ModelMapper modelMapper, Gson gson) {
        this.companyRepository = companyRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void importCompanies() throws JAXBException {
        CompanyRootDto companyRootDto = this.xmlParser.parseXml(CompanyRootDto.class, XML_PATH);

        for (CompanyDto companyDto :companyRootDto.getCompanyDtos()) {
            this.companyRepository.save(this.modelMapper.map(companyDto, Company.class));
        }
    }

    @Override
    public boolean areImported() {
        return this.companyRepository.count() > 0;
    }

    @Override
    public String readCompaniesXmlFile() {
        String xml = "";
        try {
            xml = String.join("\n", Files.readAllLines(Paths.get(XML_PATH)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return xml;
    }

    @Override
    public List<CompanyViewModel> findAll() {

        return this.companyRepository
                .findAll()
                .stream()
                .map(e -> this.modelMapper.map(e, CompanyViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public String companiesToJson() {

        return this.gson.toJson(findAll());
    }
}
