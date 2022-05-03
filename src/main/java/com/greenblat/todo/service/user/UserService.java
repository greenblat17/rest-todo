package com.greenblat.todo.service.user;

import com.greenblat.todo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> getAll();

    User getById(long id);

    void deleteById(long id);

    User save(User user);
}
