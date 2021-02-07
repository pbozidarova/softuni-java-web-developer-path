package bg.softuni.mobilele.mobilele.web;

import bg.softuni.mobilele.mobilele.model.service.UserLoginServiceModel;
import bg.softuni.mobilele.mobilele.security.CurrentUser;
import bg.softuni.mobilele.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class LoginController {

    private UserService userService;

    @ModelAttribute("userModel")
    public UserLoginServiceModel userModel(){
        return new UserLoginServiceModel();
    }

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String showLogin() {
        return "/auth-login";
    }

    @PostMapping("/users/login")
    public String login(@Valid @ModelAttribute UserLoginServiceModel userModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/login";
        }

        if (userService.authenticate(userModel.getUsername(), userModel.getPassword())) {
            userService.loginUser(userModel.getUsername());
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:/users/login";
        }
    }

    @PostMapping("/users/logout")
    public String login() {
        userService.logoutUser();

        return "redirect:/";
    }
}
