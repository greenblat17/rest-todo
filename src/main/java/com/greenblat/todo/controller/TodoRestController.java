package com.greenblat.todo.controller;

import com.greenblat.todo.model.Todo;
import com.greenblat.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoRestController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> allTodos =  todoService.getAll();
        System.out.println(allTodos);
        return new ResponseEntity<>(allTodos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getOneTodo(@PathVariable("id") long id) {
        Todo todo = todoService.getById(id);
        System.out.println(todo);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable("id") long id) {
        todoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        todoService.save(todo);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
        Todo updatedTodo = todoService.save(todo);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }
}
