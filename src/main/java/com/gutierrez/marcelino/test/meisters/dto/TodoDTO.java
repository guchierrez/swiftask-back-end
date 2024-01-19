package com.gutierrez.marcelino.test.meisters.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class TodoDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Size(max = 30)
    private String name;

    @NotEmpty(message = "Description cannot be empty")
    @Size(max = 150)
    private String description;

    private boolean completed;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
