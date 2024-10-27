package org.example.repository;

import org.example.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonRepository {

    Optional<Person> entry(String userName, String password);

    void create(Person person);

    boolean checkUserName(String userName);

    boolean checkEmail(String email);

    void update(Person person);

    void delete(UUID id);

    List<Person> getAll();

    Optional<Person> getById(UUID id);

    Person updateById(UUID id, Person person);
}

