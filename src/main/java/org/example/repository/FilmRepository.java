package org.example.repository;

import org.example.model.Film;

import java.util.List;
import java.util.Optional;

public interface FilmRepository {

    Film create(Film film);

    void update(Film film);

    void delete(Integer id);

    boolean checkFilmName(String filmName);

    List<Film> getAll();

    Optional<Film> getById(Integer id);

    Film updateById(Integer id, Film film);

}
