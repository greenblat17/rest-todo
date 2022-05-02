package com.greenblat.todo.service;

import com.greenblat.todo.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAll();

    Todo getById(long id);

    void deleteById(long id);

    Todo save(Todo todo);
}
