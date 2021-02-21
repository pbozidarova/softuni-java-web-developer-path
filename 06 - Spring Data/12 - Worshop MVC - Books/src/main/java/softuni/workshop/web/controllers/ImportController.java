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
    public ModelAndView xmls(){
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
    public ModelAndView companies(){
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
    public ModelAndView projects(){

        return this.view("xml/import-projects");
    }

    @GetMapping("/employees")
    public ModelAndView employees(){

        return this.view("xml/import-employees");
    }
}


