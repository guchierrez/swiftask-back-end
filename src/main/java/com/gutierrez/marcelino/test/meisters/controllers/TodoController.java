package com.gutierrez.marcelino.test.meisters.controllers;

import com.gutierrez.marcelino.test.meisters.domain.todo.RequestTodo;
import com.gutierrez.marcelino.test.meisters.domain.todo.RequestTodoUpdate;
import com.gutierrez.marcelino.test.meisters.domain.todo.Todo;
import com.gutierrez.marcelino.test.meisters.domain.todo.TodoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoRepository repository;

    @GetMapping
    public ResponseEntity getAllTodos() {
        var allTodos = repository.findAll();
        return ResponseEntity.ok(allTodos);
    }

    @PostMapping
    public ResponseEntity createTodo(@RequestBody @Valid RequestTodo data) {
        Todo newTodo = new Todo(data);
        repository.save(newTodo);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity updateTodo(@PathVariable String id, @RequestBody @Valid RequestTodo data) {
        Optional<Todo> optionalTodo = repository.findById(id);
        if (optionalTodo.isPresent()) {
        Todo todo = optionalTodo.get();
        todo.setDescription(data.description());
        todo.setTitle(data.title());
        todo.setCompleted(data.completed());
        return ResponseEntity.ok(todo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id")
    public ResponseEntity deleteTodo(@PathVariable String id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
