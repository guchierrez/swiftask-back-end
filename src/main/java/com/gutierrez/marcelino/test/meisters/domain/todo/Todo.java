package com.gutierrez.marcelino.test.meisters.domain.todo;

import jakarta.persistence.*;
import lombok.*;

@Table(name="todos")
@Entity(name="todo")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Todo {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String description;
    private boolean completed;
    public Todo(RequestTodo requestTodo){
        this.description = requestTodo.description();
        this.title = requestTodo.title();
        this.completed = requestTodo.completed();
    }
}
