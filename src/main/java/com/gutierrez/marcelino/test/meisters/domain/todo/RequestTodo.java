package com.gutierrez.marcelino.test.meisters.domain.todo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestTodo(@NotBlank String title, @NotBlank String description, boolean completed) { }

