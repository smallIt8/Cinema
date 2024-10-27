package org.example.repository;

import org.example.model.Seat;
import org.example.model.Ticket;
import org.example.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.example.util.constant.SqlQueryConstant.*;

public class TicketRepositoryImpl implements TicketRepository {

    @Override
    public void create(List<Ticket> tickets) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection
                    .prepareStatement(CREATE_TICKET);
            for (Ticket ticket : tickets) {
                statement.setLong(1, ticket.getFilmId().getId());
                statement.setInt(2, ticket.getSeat().getNumber());
                statement.setLong(3, ticket.getPrice());
                statement.setTimestamp(4, Timestamp.valueOf(ticket.getDateTime()));
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void updateSessionsByFilmId(Long filmId, LocalDateTime oldDateTime, List<LocalDateTime> newDateTimes) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection
                    .prepareStatement(UPDATE_TICKET);
            for (LocalDateTime newDateTime : newDateTimes) {
                statement.setTimestamp(1, Timestamp.valueOf(newDateTime));
                statement.setLong(2, filmId);
                statement.setTimestamp(3, Timestamp.valueOf(oldDateTime));
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<LocalDateTime> getAllSessionsByFilmId(Long filmId) {
        List<LocalDateTime> dateTimes = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection
                    .prepareStatement(GET_ALL_SESSION_BY_FILM_ID);
            statement.setLong(1, filmId);
            ResultSet query = statement.executeQuery();
            while (query.next()) {
                LocalDateTime dateTime = query.getTimestamp("date_time").toLocalDateTime();
                dateTimes.add(dateTime);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return dateTimes;
    }

    @Override
    public List<Seat> getListSeatSessionFilm(Long filmId, LocalDateTime session) {
        List<Seat> seats = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection
                    .prepareStatement(GET_ALL_SEAT_BY_SESSION_BY_FILM_ID);
            statement.setLong(1, filmId);
            statement.setTimestamp(2, Timestamp.valueOf(session));
            ResultSet query = statement.executeQuery();
            while (query.next()) {
                int seatNumber = query.getInt("seat");
                Seat seat = Seat.fromNumber(seatNumber);
                seats.add(seat);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return seats;
    }

@Override
public boolean checkDateTime(LocalDateTime dateTime) {
    try (Connection connection = ConnectionManager.open()) {
        PreparedStatement statement = connection
                .prepareStatement(CHECK_DATE_TIME_FILM);
        statement.setTimestamp(1, Timestamp.valueOf(dateTime));
        ResultSet query = statement.executeQuery();
        query.next();
        return query.getInt(1) > 0;
    } catch (Exception e) {
        throw new RuntimeException(e.getMessage());
    }
}
}
