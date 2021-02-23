package com.softuni.service;

import com.softuni.model.enitity.Homework;
import com.softuni.model.service.HomeworkServiceModel;
import com.softuni.model.view.HomeworkViewModel;

public interface HomeworkService {
    void addHomework(String exercise, String gitAddress);

    HomeworkServiceModel findHomeworkForScoring();

    Homework findByID(Long homeworkId);
}
