package com.softuni.service.impl;


import com.softuni.model.enitity.Homework;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements com.softuni.service.HomeworkService {
    private final com.softuni.repository.HomeworkRepository homeworkRepository;
    private final com.softuni.service.ExerciseService exerciseService;
    private final com.softuni.security.CurrentUser currentUser;
    private final com.softuni.service.UserService userService;

    public HomeworkServiceImpl(com.softuni.repository.HomeworkRepository homeworkRepository, com.softuni.service.ExerciseService exerciseService, com.softuni.security.CurrentUser currentUser, com.softuni.service.UserService userService) {
        this.homeworkRepository = homeworkRepository;
        this.exerciseService = exerciseService;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public void addHomework(String exercise, String gitAddress) {
        Homework homework = new Homework();

        homework.setGitAddress(gitAddress);
        homework.setAddedOn(LocalDateTime.now());
        homework.setExercise(this.exerciseService.findByName(exercise));
        homework.setAuthor(userService.findById(currentUser.getId()));

        homeworkRepository.save(homework);
    }
}
