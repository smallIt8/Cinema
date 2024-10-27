package org.example.service;

import org.example.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonService {

    void entry();

    void adminMenu();

    void managerMenu();

    void userMenu();

    void create();

    List<Person> getAll(); //для админа

    Optional<Person> getById(UUID id); //для админа

    void update(Person person); //для юзера

    Person updateById(UUID id, Person person); //для админа

    void delete(UUID id); //для админа
}