package com.greenblat.todo.service;

import com.greenblat.todo.model.Todo;
import com.greenblat.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getById(long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        return optionalTodo.orElseGet(Todo::new);
    }

    @Override
    public void deleteById(long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }
}
