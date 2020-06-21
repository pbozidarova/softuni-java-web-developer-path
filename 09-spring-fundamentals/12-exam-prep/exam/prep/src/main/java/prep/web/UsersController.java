package prep.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import prep.model.binding.UserLoginBindingModel;
import prep.model.binding.UserRegisterBindingModel;
import prep.model.service.UserServiceModel;
import prep.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UsersController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute("userLoginBindingModel")
                                           UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes,
                               HttpSession httpSession
                               ){
        if(bindingResult.hasErrors()){
            return "redirect:login";
        }

        UserServiceModel user = this.userService.findByUsername(userLoginBindingModel.getUsername());

        if(!user.getPassword().equals(userLoginBindingModel.getPassword())){
            redirectAttributes.addFlashAttribute("notFound", true);

            return "redirect:login";
        }

            httpSession.setAttribute("user", );

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute("userRegisterBindingModel")
                                              UserRegisterBindingModel userRegisterBindingModel,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes
                                  ){
        if(bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())){
            //todo redirect att
            return "redirect:register";
        }

        this.userService.register(this.modelMapper
                .map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";
    }
}
