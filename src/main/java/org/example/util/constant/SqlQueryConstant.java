package org.example.util.constant;

public final class SqlQueryConstant {

    public static final String ENTRY_PERSON = "SELECT * FROM person WHERE user_name = ? AND password = ?;";
    public static final String CREATE_PERSON = "INSERT INTO person(id, user_name, password, email) VALUES (?, ?, ?, ?)";
    public static final String CREATE_FILM = "INSERT INTO film (film_name, year, country, description) VALUES (?, ?, ?, ?)";
    public static final String CREATE_TICKET = "INSERT INTO tickets (film_id, seat, price, date_time) VALUES (?, ?, ?, ?)";
    public static final String UPDATE_FILM = "UPDATE film SET film_name = ?, year = ?, country = ?, description = ? WHERE id = ?";
    public static final String UPDATE_TICKET = "UPDATE tickets SET dat_time = ? WHERE film_id = ? AND date_time = ?";
    public static final String GET_ALL_PERSON = "SELECT * FROM person;";
    public static final String GET_ALL_FILM = "SELECT * FROM film;";
    public static final String GET_ALL_SESSION_BY_FILM_ID = "SELECT DISTINCT date_time FROM tickets WHERE film_id = ?";
    public static final String GET_ALL_SEAT_BY_SESSION_BY_FILM_ID = "SELECT DISTINCT seat FROM tickets WHERE film_id = ? AND  date_time = ?";
    public static final String GET_BY_ID_PERSON = "SELECT * FROM person WHERE id = ?;";
    public static final String GET_BY_ID_FILM = "SELECT * FROM person WHERE id = ?;";
    public static final String CHECK_USER_NAME_PERSON = "SELECT COUNT(*) FROM person WHERE user_name = ?";
    public static final String CHECK_EMAIL_PERSON = "SELECT COUNT(*) FROM person WHERE email = ?";
    public static final String CHECK_FILM_NAME_FILM = "SELECT COUNT(*) FROM film WHERE film_name = ?";
    public static final String CHECK_DATE_TIME_FILM = "SELECT COUNT(*) FROM tickets WHERE date_time = ?";

    private SqlQueryConstant() {
    }
}

