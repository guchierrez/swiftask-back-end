package com.gutierrez.marcelino.test.meisters.service;

import com.gutierrez.marcelino.test.meisters.model.Todo;
import com.gutierrez.marcelino.test.meisters.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(final Todo todoData) {

        final Todo newTodo = new Todo(todoData.getName(), todoData.getDescription());

        return todoRepository.save(newTodo);
    }

    public List<Todo> readTodos() {
        return todoRepository.findAll();
    }

    public Todo updateTodo(Todo todoData, final long id) throws Exception {
        final Todo foundTodo = todoRepository.findById(id).orElseThrow(() -> new Exception("User not found"));

        foundTodo.setName(todoData.getName());
        foundTodo.setDescription(todoData.getDescription());
        foundTodo.setCompleted(todoData.isCompleted());

        return todoRepository.save(foundTodo);
    }

    public void deleteTodo(final Long id) throws Exception {
        final Todo foundTodo = todoRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
        todoRepository.delete(foundTodo);
    }
}
