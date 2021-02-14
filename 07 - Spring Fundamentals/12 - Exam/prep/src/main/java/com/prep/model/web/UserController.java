package com.prep.model.web;

import com.prep.model.binding.UserRegisterBM;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/register")
    public String register(Model model){
        if(!model.containsAttribute("userRegisterBM")){
            model.addAttribute("userRegisterBM", new UserRegisterBM());
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBM userRegisterBM,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userRegisterBM", userRegisterBM);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBM", bindingResult);

            return "redirect:/register";
        }
        //todo save in db
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

}
