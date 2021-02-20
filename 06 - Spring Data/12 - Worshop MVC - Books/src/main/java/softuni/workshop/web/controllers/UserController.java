package softuni.workshop.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.workshop.web.models.UserRegisterModel;

@Controller
public class UserController extends BaseController {

    @GetMapping("/users/register")
    public ModelAndView register() {

        return new ModelAndView("/user/register");
    }

    @PostMapping("/users/register")
    public ModelAndView registerConfirmed(){

//        this.userService.register(UserRegisterModel userModel);

        return new ModelAndView("redirect:/users/login");
    }
}
