package com.gutierrez.marcelino.test.meisters.domain.todo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestTodoUpdate( String title, String description, boolean completed) { }

