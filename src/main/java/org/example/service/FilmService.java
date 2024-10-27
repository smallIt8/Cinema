package org.example.service;

import org.example.model.Film;
import org.example.model.Role;

import java.util.Optional;

public interface FilmService {

    void adminFilm();

    void managerFilm();

    void userfilm();

    void create();

    void getAll();

    Optional<Film> getById(Integer id);

    Film update(Film film);

    Film updateById(Integer id, Film film);

    void delete(Long id);

    void setUserRole(Role userRole);

}
