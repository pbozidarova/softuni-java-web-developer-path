package softuni.workshop.service.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.workshop.data.dto.ProjectDto;
import softuni.workshop.data.dto.ProjectsRootDto;
import softuni.workshop.data.entities.Company;
import softuni.workshop.data.entities.Project;
import softuni.workshop.data.repositories.CompanyRepository;
import softuni.workshop.data.repositories.ProjectRepository;
import softuni.workshop.service.services.ProjectService;
import softuni.workshop.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final String XML_PATH = "src/main/resources/files/xmls/projects.xml";
    private final CompanyRepository companyRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, CompanyRepository companyRepository, XmlParser xmlParser, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.companyRepository = companyRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }


    @Override
    public void importProjects() throws JAXBException {
        ProjectsRootDto projectsRootDto = this.xmlParser.parseXml(ProjectsRootDto.class, XML_PATH);

        for (ProjectDto projectDto : projectsRootDto.getProjectDtos()) {
            Project project = this.modelMapper.map(projectDto, Project.class);

            Company company = this.companyRepository.findByName(projectDto.getCompanyDto().getName());
            project.setCompany(company);

            this.projectRepository.save(project);
        }
    }

    @Override
    public boolean areImported() {

        return this.projectRepository.count() > 0;
    }

    @Override
    public String readProjectsXmlFile() {
        String xml = "";
        try {
            xml = String.join("\n", Files.readAllLines(Paths.get(XML_PATH)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return xml;
    }

    @Override
    public String exportFinishedProjects(){
        //TODO export finished projects
        return null;
    }
}
