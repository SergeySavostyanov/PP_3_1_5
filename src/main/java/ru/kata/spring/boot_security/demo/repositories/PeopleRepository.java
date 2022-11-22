package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.model.Person;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person,Long> {
    Optional<Person> findByEmail(String email);
}
