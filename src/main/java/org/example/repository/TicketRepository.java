package org.example.repository;

import org.example.model.Seat;
import org.example.model.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository {

    void create(List<Ticket> tickets);

    void updateSessionsByFilmId(Long filmId, LocalDateTime oldDateTime, List<LocalDateTime> newDateTimes);

    boolean checkDateTime(LocalDateTime dateTime);

    List<LocalDateTime> getAllSessionsByFilmId(Long filmId);

    List<Seat> getListSeatSessionFilm(Long filmId, LocalDateTime session);

}