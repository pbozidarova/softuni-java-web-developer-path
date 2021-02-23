package com.softuni.web;

import com.softuni.security.CurrentUser;
import com.softuni.service.CommentService;
import com.softuni.service.ExerciseService;
import com.softuni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ExerciseService exerciseService;
    private final CommentService commentService;
    private final UserService userService;

    @Autowired
    public HomeController(CurrentUser currentUser, ExerciseService exerciseService, CommentService commentService, UserService userService) {
        this.currentUser = currentUser;
        this.exerciseService = exerciseService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model){

        if(currentUser.isAnonymous()){
            return "index";
        }else {
            model.addAttribute("exercises", exerciseService.findAllExNames());
            model.addAttribute("avg", commentService.findAvgScore());
            model.addAttribute("usersCount", userService.findUsersCount() );
            model.addAttribute("scoreMap", this.commentService.findScoreMap());

            return "home";
        }

    }
}
