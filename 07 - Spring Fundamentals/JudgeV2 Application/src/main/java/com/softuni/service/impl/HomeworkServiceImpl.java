package com.softuni.service.impl;


import com.softuni.model.enitity.Homework;
import com.softuni.model.service.HomeworkServiceModel;
import com.softuni.repository.HomeworkRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.ExerciseService;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements com.softuni.service.HomeworkService {
    private final com.softuni.repository.HomeworkRepository homeworkRepository;
    private final com.softuni.service.ExerciseService exerciseService;
    private final com.softuni.security.CurrentUser currentUser;
    private final com.softuni.service.UserService userService;
    private final ModelMapper modelMapper;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, ExerciseService exerciseService, CurrentUser currentUser, UserService userService, ModelMapper modelMapper) {
        this.homeworkRepository = homeworkRepository;
        this.exerciseService = exerciseService;
        this.currentUser = currentUser;
        this.userService = userService;
        this.modelMapper = modelMapper;
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

    @Override
    public HomeworkServiceModel findHomeworkForScoring() {
        return homeworkRepository
                .findTop1ByOrderByComments()
                .map(hw -> modelMapper.map(hw, HomeworkServiceModel.class))
                .orElse(null);

    }

    @Override
    public Homework findByID(Long homeworkId) {

        return homeworkRepository.findById(homeworkId).orElse(null);
    }
}
