package org.example.service;

import org.example.model.Film;
import org.example.model.Role;
import org.example.model.Seat;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketService {

    void create(Film film);

    LocalDateTime update(LocalDateTime selectedSession, Film selectedFilm);

    List<LocalDateTime> getSessionsFilm(Film selectedFilm);

    void selectedSeat(Film selectedFilm, LocalDateTime selectedSession);

    void purchaseTicket(Seat selectedSeat, Film selectedFilm, LocalDateTime selectedSession);

    List<Seat> getListSeatFilm(Film selectedFilm, LocalDateTime selectedSession);

    void entrySeat(List<Seat> seats, Film selectedFilm, LocalDateTime selectedSession);

    void refund();

    void delete();

    void setUserRole(Role userRole);
}

