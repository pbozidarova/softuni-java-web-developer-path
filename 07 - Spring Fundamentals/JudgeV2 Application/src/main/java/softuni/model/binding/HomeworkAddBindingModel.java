package com.softuni.model.binding;

import com.softuni.model.enitity.Exercise;
import com.softuni.model.enitity.User;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class HomeworkAddBindingModel {

    public String exercise;
    public String gitAddress;

    public HomeworkAddBindingModel() {
    }

    @Size(min=2)
    public String getExercise() {
        return exercise;
    }

    public HomeworkAddBindingModel setExercise(String exercise) {
        this.exercise = exercise;
        return this;
    }

    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+",
            message = "Enter valid git address!")    public String getGitAddress() {
        return gitAddress;
    }

    public HomeworkAddBindingModel setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
        return this;
    }
}
