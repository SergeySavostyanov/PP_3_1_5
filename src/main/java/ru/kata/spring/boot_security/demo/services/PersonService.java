package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.model.Person;

import java.util.List;

public interface PersonService {
    Person getById(Long id);

    List<Person> listUsers();

    void saveUser(Person person);

    void removeUser(Long id);

    //void updateUser(User user);
}
