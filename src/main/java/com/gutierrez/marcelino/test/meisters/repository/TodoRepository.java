package com.gutierrez.marcelino.test.meisters.repository;

import com.gutierrez.marcelino.test.meisters.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    boolean existsTodoByName(final String name);
}