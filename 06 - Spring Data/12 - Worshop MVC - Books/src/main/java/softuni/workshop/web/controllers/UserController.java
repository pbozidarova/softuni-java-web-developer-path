package softuni.workshop.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.workshop.service.services.UserService;
import softuni.workshop.web.models.UserRegisterModel;

@Controller
public class UserController extends BaseController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public ModelAndView register() {

        return new ModelAndView("/user/register");
    }

    @PostMapping("/users/register")
    public ModelAndView registerConfirmed(@ModelAttribute UserRegisterModel userRegisterModel){

        if(!userRegisterModel.getPassword().equals(userRegisterModel.getConfirmPassword())){

            return new ModelAndView("redirect:/users/register");
        }

        this.userService.registerUser(userRegisterModel);

        return new ModelAndView("redirect:/user/login");
    }
}
