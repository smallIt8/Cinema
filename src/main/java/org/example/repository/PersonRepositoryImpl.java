package org.example.repository;

import org.example.model.Person;
import org.example.model.Role;
import org.example.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.example.util.constant.SqlQueryConstant.*;

public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public Optional<Person> entry(String userName, String password) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection
                    .prepareStatement(ENTRY_PERSON);
            statement.setString(1, userName);
            statement.setString(2, password);
            ResultSet query = statement.executeQuery();
            if (query.next()) {
                Person person = new Person();
                person.setId(UUID.fromString(query.getString("id")));
                person.setUserName(query.getString("user_name"));
                person.setPassword(query.getString("password"));
                person.setEmail(query.getString("email"));
                person.setRole(Role.valueOf(query.getString("role").toUpperCase()));
                return Optional.of(person);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void create(Person person) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection
                    .prepareStatement(CREATE_PERSON);
            statement.setString(1, person.getId().toString());
            statement.setString(2, person.getUserName());
            statement.setString(3, person.getPassword());
            statement.setString(4, person.getEmail());
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean checkUserName(String userName) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection
                    .prepareStatement(CHECK_USER_NAME_PERSON);
            statement.setString(1, userName);
            ResultSet query = statement.executeQuery();
            query.next();
            return query.getInt(1) > 0;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean checkEmail(String email) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection
                    .prepareStatement(CHECK_EMAIL_PERSON);
            statement.setString(1, email);
            ResultSet query = statement.executeQuery();
            query.next();
            return query.getInt(1) > 0;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<Person> getAll() {
        List<Person> people = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection
                    .prepareStatement(GET_ALL_PERSON);
            ResultSet query = statement.executeQuery();
            while (query.next()) {
                String id = query.getString("id");
                String userName = query.getString("user_name");
                String password = query.getString("password");
                String email = query.getString("email");
                Role role = Role.valueOf(query.getString("role").toUpperCase());
                Person person = new Person(UUID.fromString(id), userName, password, email, role);
                people.add(person);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return people;
    }

    @Override
    public Optional<Person> getById (UUID id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection
                    .prepareStatement(GET_BY_ID_PERSON);
            statement.setString(1, id.toString());
            ResultSet query = statement.executeQuery();
            if (query.next()) {
                Person person = new Person();
                person.setId(id);
                person.setUserName(query.getString("user_name"));
                person.setPassword(query.getString("password"));
                person.setEmail(query.getString("email"));
                person.setRole(Role.valueOf(query.getString("role").toUpperCase()));
                return Optional.of(person);
            }
        } catch (Exception e) {
            // логи + произошла ошибка получения пользователя из таблицы такой-то с id таким-то
            throw new RuntimeException(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Person updateById(UUID id, Person person) {
        return null;
    }
}
