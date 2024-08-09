package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User getById(Long id);

    void saveUser(User user);

    User findUserByUsername(String username);

    void updateUser(User user);

    void deleteUser(Long id);
}
