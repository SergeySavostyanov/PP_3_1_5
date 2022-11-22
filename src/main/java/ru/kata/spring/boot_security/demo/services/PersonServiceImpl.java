package ru.kata.spring.boot_security.demo.services;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Person;
import ru.kata.spring.boot_security.demo.repositories.PeopleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private PeopleRepository peopleRepository;
    public PersonServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public Person getById(Long id) {
        return peopleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> listUsers() {
        return peopleRepository.findAll();
    }

    @Transactional
    @Override
    public void saveUser(Person person) {
        peopleRepository.save(person);
    }
    @Transactional
    @Override
    public void removeUser(Long id) {
        peopleRepository.deleteById(id);
    }

}
