package bg.softuni.cloudinary.web;

import bg.softuni.cloudinary.model.StudentBindingModel;
import bg.softuni.cloudinary.service.StudentService;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

  private final StudentService studentService;

  public HomeController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @PostMapping("/add")
  public String add(Model model, @ModelAttribute("studentBindingModel")
      StudentBindingModel studentBindingModel) throws IOException {
    this.studentService.addStudent(studentBindingModel);
    model.addAttribute("students", this.studentService.findAll());
    return "home";
  }
}
