package com.gutierrez.marcelino.test.meisters.controller;

import com.gutierrez.marcelino.test.meisters.dto.TodoDTO;
import com.gutierrez.marcelino.test.meisters.model.Todo;
import com.gutierrez.marcelino.test.meisters.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody final TodoDTO todoData) {
        final Todo createdTodo = todoService.createTodo(todoData);

        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> readUsers () {
        final List<Todo> allTodos = todoService.readTodos();

        return new ResponseEntity<>(allTodos, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Todo> updateUser(@RequestBody final TodoDTO todoData, @PathVariable String id){
        final Todo updatedTodo = todoService.updateTodo(todoData, Long.parseLong(id));

        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        todoService.deleteTodo(Long.parseLong(id));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
