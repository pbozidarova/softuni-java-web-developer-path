package softuni.workshop.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.workshop.service.services.CompanyService;
import softuni.workshop.service.services.EmployeeService;
import softuni.workshop.service.services.ProjectService;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {

    private final ProjectService projectService;
    private final EmployeeService employeeService;
    private final CompanyService companyService;

    @Autowired
    public ExportController(ProjectService projectService, EmployeeService employeeService, CompanyService companyService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @GetMapping("/project-if-finished")
    public ModelAndView finishedProjects(){
        ModelAndView modelAndView = new ModelAndView("/export/export-project-if-finished");

        String projectsIfFinished = this.projectService.exportFinishedProjects();

        modelAndView.addObject("projectsIfFinished", projectsIfFinished);

        return modelAndView;
    }

    @GetMapping("/employees-above")
    public ModelAndView employeesAbove(){
        ModelAndView modelAndView = new ModelAndView("/export/export-employees-with-age");

        String employeesAbove = this.employeeService.exportEmployeesWithAgeAbove();

        modelAndView.addObject("employeesAbove", employeesAbove);

        return modelAndView;
    }

    @GetMapping("/companies-json")
    public ModelAndView companiesJson(){
        ModelAndView modelAndView = new ModelAndView("/export/export-companies-json");

        String allCompanies = this.companyService.companiesToJson();

        modelAndView.addObject("allCompanies", allCompanies);

        return modelAndView;
    }

    @GetMapping("/employees-json")
    public ModelAndView employeesJson(){
        ModelAndView modelAndView = new ModelAndView("/export/export-employees-json");

        String allEmployees = this.employeeService.employeesToJson();

        modelAndView.addObject("allEmployees", allEmployees);

        return modelAndView;
    }
}
