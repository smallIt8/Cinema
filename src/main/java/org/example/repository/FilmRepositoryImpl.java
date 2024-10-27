package org.example.repository;

import com.mysql.jdbc.Statement;
import org.example.model.Film;
import org.example.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.*;

import static org.example.util.constant.SqlQueryConstant.*;

public class FilmRepositoryImpl implements FilmRepository {

    @Override
    public Film create(Film film) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection
                    .prepareStatement(CREATE_FILM, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, film.getFilmName());
            statement.setString(2, film.getYear());
            statement.setString(3, film.getCountry());
            statement.setString(4, film.getDescription());
            statement.executeUpdate();
            try (ResultSet query = statement.getGeneratedKeys()){
                if (query.next()) {
                    Long id = query.getLong(1);
                    film.setId(id);
                }
            }
            return film;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Film selectedFilm) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection
                    .prepareStatement(UPDATE_FILM);
            statement.setString(1, selectedFilm.getFilmName());
            statement.setString(2, selectedFilm.getYear());
            statement.setString(3, selectedFilm.getCountry());
            statement.setString(4, selectedFilm.getDescription());
            statement.setLong(5, selectedFilm.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Error updating film", e);
        }
    }

    @Override
    public boolean checkFilmName(String filmName) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection
                    .prepareStatement(CHECK_FILM_NAME_FILM);
            statement.setString(1, filmName);
            ResultSet query = statement.executeQuery();
            query.next();
            return query.getInt(1) > 0;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Film> getAll() {
        List<Film> films = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection
                    .prepareStatement(GET_ALL_FILM);
            ResultSet query = statement.executeQuery();
            while (query.next()) {
                Long id = query.getLong("id");
                String filmName = query.getString("film_name");
                String year = query.getString("year");
                String country = query.getString("country");
                String description = query.getString("description");
                Film film = new Film(id, filmName, year, country, description);
                films.add(film);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return films;
    }

    @Override
    public Optional<Film> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Film updateById(Integer id, Film film) {
        return null;
    }
}