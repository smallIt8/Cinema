package org.example.exception;

import org.example.util.Utils;

public final class CinemaExceptionMessage {

    // ========== Сообщения об ошибках создания ==========
    public static final String ERROR_CREATION_USER_NAME_MESSAGE = Utils.colorizeRedText("Пользователь с таким логином уже зарегистрирован.");
    public static final String ERROR_CREATION_FILM_NAME_MESSAGE = Utils.colorizeRedText("Фильм с таким названием уже есть в базе.");
    public static final String ERROR_CREATION_EMAIL_MESSAGE = Utils.colorizeRedText("Пользователь с таким email уже зарегистрирован.");
    public static final String ERROR_ADD_FILM_DATE_TIME_MESSAGE = Utils.colorizeRedText("На выбранную дату и время сеанс уже назначен");

    // ========== Сообщения об ошибках ввода ==========
    public static final String ERROR_ENTER_MESSAGE = Utils.colorizeRedText("Неверный ввод.\nповторите ввод: ");
    public static final String ERROR_ENTER_MAX_ATTEMPTS_MESSAGE = Utils.colorizeRedText("Превышено допустимое количество попыток ввода.");
    public static final String ERROR_ENTER_USER_NAME_OR_PASSWORD_MESSAGE = Utils.colorizeRedText("Неверный логин или пароль.\nПовторите вход.");
    public static final String ERROR_ENTER_USER_NAME_MESSAGE = Utils.colorizeRedText("""
            Неверный ввод.
            Логин должен содержать от 4 до 100 символов, включая буквы и цифры.
            """
    );
    public static final String ERROR_ENTER_PASSWORD_MESSAGE = Utils.colorizeRedText("""
            Неверный ввод.
            Пароль должен содержать от 8 до 25 символов, включая специальный символ '_',
            как минимум одну заглавную букву, одну строчную букву и одну цифру.
            """
    );
    public static final String ERROR_ENTER_EMAIL_MESSAGE = Utils.colorizeRedText("""
            Неверный ввод.
            Email должен быть в формате '*****@****.***',
            содержать от 4 до 25 символов перед '@', включая буквы, цифры и специальные символы '_-',
            содержать от 2 до 25 символов между '@' и '.', включая буквы, цифры и специальный символ '-',
            содержать от 2 до 10 символов после '.', включая только буквы.
            """
    );

    public static final String ERROR_ENTER_FILM_NUMBER_MESSAGE = Utils.colorizeRedText("Неверный ввод.\nФильм с таким номером отсутствует.");
    public static final String ERROR_ENTER_FILM_YEAR_MESSAGE = Utils.colorizeRedText("""
            Неверный ввод.
            Год должен содержать 4 символа, включая цифры и
            быть в пределах от 1920 до 2100 годов.
            """
    );
    public static final String ERROR_ENTER_FILM_TIME_NUMBER_MESSAGE = Utils.colorizeRedText("Неверный ввод.\nВремя с таким номером отсутствует. ввод");
    public static final String ERROR_ENTER_FILM_COUNTRY_MESSAGE = Utils.colorizeRedText("""
            Неверный ввод.
            Название страны должно содержать от 2 до 100 символов,
            включая буквы, пробелы и специальные символы '-,'.
            """
    );
    public static final String ERROR_ENTER_FILM_DESCRIPTION_MESSAGE = Utils.colorizeRedText("""
            Неверный ввод.
            Описание фильма должно содержать от 5 до 200 символов,
            включая буквы, цифры, пробелы, переносы строк и специальные символы '.,?!-_ '\"()',
            """
    );
    public static final String ERROR_ENTER_FILM_DATE_MESSAGE = Utils.colorizeRedText("""
             Неверный ввод.
             Дату должна быть в диапазоне
             не ранее следующего дня от текущего и
             не позднее 30 дней от текущего."""
    );
    public static final String ERROR_ENTER_FILM_FORMAT_DATE_MESSAGE = Utils.colorizeRedText("Неверный ввод.\nДата должна быть в формате yyyy.MM.dd.");
    public static final String ERROR_ENTER_FILM_NAME_MESSAGE = Utils.colorizeRedText("""
            Неверный ввод.
            Название фильма должно содержать от 3 до 100 символов,
            включая буквы, цифры, пробелы и
            специальные символы '.,?!-_'\":()'
            """
    );

    public static final String ERROR_ENTER_SESSION_NUMBER_MESSAGE = Utils.colorizeRedText("Неверный ввод.\nСеанс с таким номером отсутствует.");

    private CinemaExceptionMessage() {
    }
}