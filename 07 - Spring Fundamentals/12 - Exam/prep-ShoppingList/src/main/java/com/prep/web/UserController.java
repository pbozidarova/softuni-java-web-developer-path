package com.prep.web;

import com.prep.model.binding.UserLoginBM;
import com.prep.model.binding.UserRegisterBM;
import com.prep.model.service.UserServiceModel;
import com.prep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register(Model model){
        if(!model.containsAttribute("userRegisterBM")){
            model.addAttribute("userRegisterBM", new UserRegisterBM());
            model.addAttribute("isExists", false);
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBM userRegisterBM,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){
        Boolean passwordMatches = userRegisterBM.getPassword().equals(userRegisterBM.getConfirmPassword());
        if(bindingResult.hasErrors() || !passwordMatches ){
            redirectAttributes.addFlashAttribute("userRegisterBM", userRegisterBM);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBM", bindingResult);

            return "redirect:register";
        }

        boolean isSaved = userService
                            .register(modelMapper
                                    .map(userRegisterBM, UserServiceModel.class));
        if(!isSaved){
            redirectAttributes.addFlashAttribute("userRegisterBM", userRegisterBM);
            redirectAttributes.addFlashAttribute("isExists", true);

            return "redirect:register";
        }

        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model){
        if(!model.containsAttribute("userLoginBM")){
            model.addAttribute("userLoginBM", new UserLoginBM());
            model.addAttribute("notFound", false);

        }

        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBM userLoginBM,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginBM", userLoginBM);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBM", bindingResult);

            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService.findByUserNameAndPassword(userLoginBM.getUsername(), userLoginBM.getPassword());

        if(userServiceModel == null) {
            redirectAttributes.addFlashAttribute("userLoginBM", userLoginBM);
            redirectAttributes.addFlashAttribute("notFound", true);

            return "redirect:login";
        }

        httpSession.setAttribute("user", userServiceModel);

        return "redirect:/";
    }

    @GetMapping("/logout")
    private String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }

}
