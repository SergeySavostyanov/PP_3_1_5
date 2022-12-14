package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User findById(Long id);

    void add(User user);

    void deleteUser(Long id);

    User findByEmail(String email);

    void updateUser(User user);

    List<Role> roleList();
}
