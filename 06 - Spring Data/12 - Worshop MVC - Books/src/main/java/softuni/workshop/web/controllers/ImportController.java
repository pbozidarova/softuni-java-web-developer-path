package softuni.workshop.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.workshop.service.services.CompanyService;
import softuni.workshop.service.services.EmployeeService;
import softuni.workshop.service.services.ProjectService;

import javax.xml.bind.JAXBException;

@Controller
@RequestMapping("/import")
public class ImportController extends BaseController {

    private final ProjectService projectService;
    private final EmployeeService employeeService;
    private final CompanyService companyService;


    @Autowired
    public ImportController(ProjectService projectService, EmployeeService employeeService, CompanyService companyService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @GetMapping("/xml")
    public ModelAndView xmls() {
        ModelAndView modelAndView = new ModelAndView("xml/import-xml");

        boolean[] areImported = new boolean[]{
                this.companyService.areImported(),
                this.projectService.areImported(),
                this.employeeService.areImported()
        };

        modelAndView.addObject("areImported", areImported);

        return modelAndView;
    }

    @GetMapping("/companies")
    public ModelAndView companies() {
        String xmlContent = this.companyService.readCompaniesXmlFile();
        ModelAndView modelAndView = new ModelAndView("xml/import-companies");
        modelAndView.addObject("companies", xmlContent);
        return modelAndView;
    }

    @PostMapping("/companies")
    public ModelAndView companiesConfirmed() throws JAXBException {
        this.companyService.importCompanies();

        return this.redirect("/import/xml");
    }

    @GetMapping("/projects")
    public ModelAndView projects() {
        String xmlContent = this.projectService.readProjectsXmlFile();
        ModelAndView modelAndView = new ModelAndView("xml/import-projects");
        modelAndView.addObject("projects", xmlContent);
        return modelAndView;
    }

    @PostMapping("/projects")
    public ModelAndView projectsConfirmed() throws JAXBException {
        this.projectService.importProjects();

        return this.redirect("/import/xml");
    }

    @GetMapping("/employees")
    public ModelAndView employees() {

        String xmlContent = this.employeeService.readEmployeesXmlFile();
        ModelAndView modelAndView = new ModelAndView("xml/import-employees");
        modelAndView.addObject("employees", xmlContent);
        return modelAndView;
    }

    @PostMapping("/employees")
    public ModelAndView employeesConfirmed() throws JAXBException {
        this.employeeService.importEmployees();

        return this.redirect("/import/xml");
    }

}