package com.gutierrez.marcelino.test.meisters.service;

import com.gutierrez.marcelino.test.meisters.dto.TodoDTO;
import com.gutierrez.marcelino.test.meisters.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {

    Todo createTodo(final TodoDTO todoData);
    List<Todo> readTodos();
    Todo updateTodo(TodoDTO todoData, final long id);
    void deleteTodo(final Long id);
}
