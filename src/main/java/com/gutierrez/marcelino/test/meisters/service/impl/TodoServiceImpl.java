package com.gutierrez.marcelino.test.meisters.service.impl;

import com.gutierrez.marcelino.test.meisters.dto.TodoDTO;
import com.gutierrez.marcelino.test.meisters.exception.AppException;
import com.gutierrez.marcelino.test.meisters.model.Todo;
import com.gutierrez.marcelino.test.meisters.repository.TodoRepository;
import com.gutierrez.marcelino.test.meisters.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(final TodoDTO todoData) {

        if (todoRepository.existsTodoByName(todoData.getName())) {
            throw new AppException("This to do already exists", HttpStatus.CONFLICT);
        }

        final Todo newTodo = new Todo(todoData.getName(), todoData.getDescription());
        System.out.println(todoData);

        return todoRepository.save(newTodo);

    }

    public List<Todo> readTodos() {
        return todoRepository.findAll();
    }

    public Todo updateTodo(TodoDTO todoData, final long id) {
        final Todo foundTodo = todoRepository.findById(id).orElseThrow(() -> new AppException("To do not found", HttpStatus.NOT_FOUND));

        foundTodo.setName((todoData.getName() == null) ? foundTodo.getName() : todoData.getName());
        foundTodo.setDescription((todoData.getDescription() == null) ? foundTodo.getDescription() : todoData.getDescription());

        foundTodo.setCompleted(todoData.isCompleted());

        return todoRepository.save(foundTodo);
    }

    public void deleteTodo(final Long id) {
        final Todo foundTodo = todoRepository.findById(id).orElseThrow(() -> new AppException("To do not found", HttpStatus.NOT_FOUND));
        todoRepository.delete(foundTodo);
    }
}
