package wpartone.model.service;

import org.hibernate.validator.constraints.Length;
import wpartone.service.ExerciseService;

import java.time.LocalDateTime;

public class ExerciseServiceModel extends BaseServiceModel {
    private String name;
    private LocalDateTime addedOn;
    private LocalDateTime dueDate;

    public ExerciseServiceModel(){

    }

    public ExerciseServiceModel(String name, LocalDateTime addedOn, LocalDateTime dueDate) {
        this.name = name;
        this.addedOn = addedOn;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
