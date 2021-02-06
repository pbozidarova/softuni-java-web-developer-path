package com.softuni.web;

import com.softuni.model.binding.HomeworkAddBindingModel;
import com.softuni.service.ExerciseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/homework")
public class HomeworkController {
    private final ExerciseService exerciseService;

    public HomeworkController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/add")
    public String add(Model model){
        if()

        model.addAttribute("exNames", exerciseService.findAllExNames());

        return "homework-add";
    }

    @PostMapping("/add")
    private String addConfirm(@Valid HomeworkAddBindingModel homeworkAddBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("homeworkAddBindingModel", homeworkAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.homeworkAddBindingModel", bindingResult);

            return "redirect:add";
        }
        //TODO SAVE IN DB

        return "redirect:/";

    }
}

