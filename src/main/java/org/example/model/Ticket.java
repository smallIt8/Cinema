package org.example.model;

import java.time.LocalDateTime;

public class Ticket {
    private Long id;
    private Person personId;
    private Film filmId;
    private Seat seat;
    private Long price;
    private LocalDateTime  dateTime;
    private int status;
    public static final int NUMBER_OF_TICKET = 50;


    public Ticket() {
    }

    public Ticket(Film filmId) {
        this.filmId = filmId;
    }

    public Ticket(Film filmId, Seat seat, LocalDateTime  dateTime) {
        this.filmId = filmId;
        this.seat = seat;
        this.dateTime = dateTime;
    }

    public Ticket(Film filmId, Seat seat, Long price, LocalDateTime  dateTime) {
        this.filmId = filmId;
        this.seat = seat;
        this.price = price;
        this.dateTime = dateTime;
    }

    public Ticket(Long id, Person personId, Film filmId, Seat seat, Long price,  LocalDateTime  dateTime, int status) {
        this.id = id;
        this.personId = personId;
        this.filmId = filmId;
        this.seat = seat;
        this.price = price;
        this.dateTime = dateTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Film getFilmId() {
        return filmId;
    }

    public void setFilmId(Film filmId) {
        this.filmId = filmId;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDateTime  getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime  dateTime) {
        this.dateTime = dateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}