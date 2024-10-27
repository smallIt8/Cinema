package org.example.util.constant;

import org.example.util.Utils;

public final class ConsoleMenuConstant {

    // ========== Сообщения о выполняемых действиях ==========
    public static final String WELCOME_MESSAGE = "Добро пожаловать ";
    public static final String ENTRY_MESSAGE = "Вход";
    public static final String REGISTRATION_MESSAGE = "Регистрация";
    public static final String FINISHING_MESSAGE = "Завершение программы";
    public static final String CREATION_TICKET_MESSAGE = "Создаются билеты на выбранную дату: ";

    // ========== Информационные сообщения ==========
    public static final String EMPTY_LIST_FILMS_MESSAGE = Utils.colorizeGreenText("Сейчас нет фильмов в прокате.");
    public static final String EMPTY_LIST_FILMS_TIME_MESSAGE = Utils.colorizeGreenText("Список времени сеансов пуст.");
    public static final String EMPTY_LIST_SESSIONS_MESSAGE = Utils.colorizeGreenText("Список сеансов пуст.");
    public static final String EMPTY_LIST_SEATS_MESSAGE = Utils.colorizeGreenText("Места отсутствуют.");
    public static final String LIST_FILMS_MESSAGE = Utils.colorizeGreenText("Сейчас в прокате следующие фильмы:");
    public static final String LIST_FILM_TIMES_MESSAGE = Utils.colorizeGreenText("Сейчас доступно следующее время добавляемого сеанса фильма:");
    public static final String LIST_FILM_SESSIONS_MESSAGE = Utils.colorizeGreenText("Сейчас доступны следующие сеансы выбранного фильма:");
    public static final String LIST_FILM_SEATS_MESSAGE = Utils.colorizeGreenText("Сейчас доступны следующие места на сеанс выбранного фильма:");
    public static final String PURCHASING_TICKET_FILM_MESSAGE = Utils.colorizeGreenText("Вы приобретаете билет на следующее мероприятие:");
    public static final String USER_LIST_TICKETS_MESSAGE = Utils.colorizeGreenText("Список купленных билетов:");

    // ========== Сообщения о выполненных действиях ==========
    public static final String REGISTERED_MESSAGE = Utils.colorizeGreenText("Вы зарегистрировались.");
    public static final String CREATED_FILM_MESSAGE = Utils.colorizeGreenText("Вы добавили фильм.");
    public static final String CREATED_TICKET_MESSAGE = Utils.colorizeGreenText("Успешно созданы билеты для фильма на выбранную дату: ");
    public static final String SELECTED_FILM_MESSAGE = Utils.colorizeGreenText("Вы выбрали фильм: ");
    public static final String SELECTED_FILM_DATE_TIME_MESSAGE = Utils.colorizeGreenText("Вы выбрали дату и время добавляемого сеанса фильма: ");
    public static final String SELECTED_SEAT_MESSAGE = Utils.colorizeGreenText("Вы выбрали место: ");
    public static final String SELECTED_TICKET_MESSAGE = Utils.colorizeGreenText("Вы выбрали билет: ");
    public static final String SELECTED_SESSION_MESSAGE = Utils.colorizeGreenText("Вы выбрали сеанс: ");
    public static final String BUYING_TICKET_MESSAGE = Utils.colorizeGreenText("Вы приобрели билет.");
    public static final String RETURNED_TICKET_MESSAGE = Utils.colorizeGreenText("Вы вернули билет.\nДенежные средства за билет будут возвращены на Ваш счет в течении 7 дней.");
    public static final String PAYMENT_TOTAL_MESSAGE = Utils.colorizeGreenText("Общая сумма к оплате: ");
    public static final String FILM_UPDATE_MESSAGE = Utils.colorizeGreenText("Вы обновили фильм.");
    public static final String SESSION_UPDATE_MESSAGE = Utils.colorizeGreenText("Вы обновили сеанс фильма.");

    // ========== Инструкции пользователю ==========
    public static final String ENTER_USERNAME = Utils.colorizeOrangeText("введите логин: ");
    public static final String ENTER_PASSWORD = Utils.colorizeOrangeText("введите пароль: ");
    public static final String ENTER_EMAIL = Utils.colorizeOrangeText("введите email: ");
    public static final String ENTER_FILM_NUMBER = Utils.colorizeOrangeText("введите номер фильма: ");
    public static final String ENTER_FILM_NAME = Utils.colorizeOrangeText("введите название фильма: ");
    public static final String ENTER_FILM_NAME_UPDATE = Utils.colorizeOrangeText("введите обновленное название фильма: ");
    public static final String ENTER_FILM_YEAR = Utils.colorizeOrangeText("введите год производства: ");
    public static final String ENTER_FILM_YEAR_UPDATE = Utils.colorizeOrangeText("введите обновленный год производства: ");
    public static final String ENTER_FILM_COUNTRY = Utils.colorizeOrangeText("введите страну производства: ");
    public static final String ENTER_FILM_COUNTRY_UPDATE = Utils.colorizeOrangeText("введите обновленную страну производства: ");
    public static final String ENTER_FILM_DESCRIPTION = Utils.colorizeOrangeText("введите описание (до 200 символов): ");
    public static final String ENTER_FILM_DESCRIPTION_UPDATE = Utils.colorizeOrangeText("введите обновленное описание (до 200 символов): ");
    public static final String ENTER_FILM_DATE = Utils.colorizeOrangeText("введите дату сеанса фильма в формате yyyy.MM.dd: ");
    public static final String ENTER_FILM_TIME = Utils.colorizeOrangeText("введите номер необходимого времени: ");
    public static final String ENTER_TICKET_PRICE = Utils.colorizeOrangeText("введите стоимость билета: ");
    public static final String ENTER_SEAT_NUMBER = Utils.colorizeOrangeText("введите номер места: ");
    public static final String ENTER_TICKET_NUMBER = Utils.colorizeOrangeText("введите номер билета: ");
    public static final String ENTER_SESSION_NUMBER = Utils.colorizeOrangeText("введите номер сеанса: ");
    
    // ========== Меню General ==========
    public static final String SELECT_FILM_OR_EXIT = """
            Выберите необходимый пункт меню:
            1. Выбрать фильм
            0. Выход
            
            ввод:\s""";

    public static final String SELECT_SESSION_OR_EXIT = """
            Выберите необходимый пункт меню:
            1. Выбрать сеанс
            0. Выход
            
            ввод:\s""";

    public static final String FILM_UPDATE_OR_EXIT = """
            Выберите необходимый пункт меню:
            1. Обновить фильм
            2. Обновить сеансы фильма
            0. Выход
            
            ввод:\s""";

    public static final String TICKET_UPDATE_OR_EXIT = """
            Выберите необходимый пункт меню:
            1. Обновить сеанс фильма
            2. Добавить сеанс на фильм
            0. Выход
            
            ввод:\s""";

    public static final String TICKET_ADD_OR_RETURN = """
            Выберите необходимый пункт меню:
            1. Добавить еще сеанс на фильм
            0. назад
            
            ввод:\s""";

    public static final String SELECT_SEAT_OR_EXIT = """
            Выберите необходимый пункт меню:
            1. Выбрать место
            0. Выход
            
            ввод:\s""";

    public static final String SELECT_TICKETS_RETURN = """
            Выберите необходимый пункт меню:
            1. Вернуть билет
            0. Выход
            
            ввод:\s""";

    public static final String EXIT = """
            Выберите необходимый пункт меню:
            0. Выход

            ввод:\s""";

    // ========== Меню MAIN ==========
    public static final String MAIN_MENU = """
            
                   Hello World!
            Выберите необходимый пункт меню:
            1. Вход
            2. Регистрация
            0. Выход
           
            ввод:\s""";

    //  ========== Меню ADMIN ==========
    public static final String ADMIN_MENU = """
            Кабинет администратора

            Выберите необходимый пункт меню:
            1. Действия с фильмами
            2. Действия с пользователями
            0. Выход

            ввод:\s""";

    //  ========== Меню ADMIN/Film ==========
    public static final String ADMIN_MENU_FILM = """
            Кабинет администратора/Фильмы

            Выберите необходимый пункт меню:
            1. Добавить фильм в базу
            2. Просмотреть список фильмов в базе
            3. Изменить фильм в базе по ID
            4. Удалить фильм из базы
            0. Выход

            ввод:\s""";

    public static final String ADMIN_MENU_FILM_ADD = """
            Кабинет администратора/Фильмы/Добавление
            
            Добавление фильма в базу:
            """;

    public static final String ADMIN_MENU_FILM_UPDATE = """
            Кабинет администратора/Фильмы/Список фильмов/Обновление фильма
            
            Обновление фильма в базе:
            """;

    public static final String ADMIN_MENU_TICKET_UPDATE = """
            Кабинет администратора/Фильмы/Список фильмов/Обновление сеанса
            
            Обновление сеанса фильма в базе:
            """;

    public static final String ADMIN_MENU_FILM_UPDATE_BY_ID = """
            Кабинет администратора/Фильмы/Изменить
            
            Выберете какой фильмы Вы хотите изменить:
            """;

    public static final String ADMIN_MENU_FILM_DELETE = """
            Кабинет администратора/Фильмы/Изменить
            
            Выберете какой фильмы Вы хотите удалить:
            """;

    //  ========== Меню ADMIN/Person ==========
    public static final String ADMIN_MENU_PERSON = """
            Кабинет администратора/Пользователи

            Выберите необходимый пункт меню:
            1. Добавить пользователя в базу
            2. Просмотреть список пользователей в базе
            3. Просмотреть пользователя по ID
            4. Изменить пользователя в базе
            5. Удалить пользователя из базы
            0. Выход

            ввод:\s""";

    public static final String ADMIN_PERSON_ADD = """
            Кабинет администратора/Пользователи/Добавление

            Добавление пользователя в базу
            """;

    public static final String ADMIN_PERSON_GET_ALL = """
            Кабинет администратора/Пользователи/Список пользователей
            
            Сейчас в базе следующие пользователи:
            """;

    public static final String ADMIN_PERSON_UPDATE = """
            Кабинет администратора/Пользователи/Изменить
            
            Выберете какого пользователя Вы хотите изменить:
            """;

    public static final String ADMIN_PERSON_DELETE = """
            Кабинет администратора/Фильмы/Изменить
            
            Выберете какого пользователя Вы хотите удалить:
            """;

    //  ========== Меню MANAGER ==========
    public static final String MANAGER_MENU = """
            Кабинет менеджера

            Выберите необходимый пункт меню:
            1. Фильмы
            2. Билеты
            3. Касса
            0. Выход

            ввод:\s""";

    public static final String MANAGER_FILM = """
            Кабинет менеджера/Фильмы
            
            Выберите необходимый пункт меню:
            1. Просмотреть список фильмов
            0. Выход
            
            ввод:\s""";

    public static final String MANAGER_MENU_FILM_UPDATE = """
            Кабинет менеджера/Фильмы/Список фильмов/Обновление фильма
            
            Обновление фильма в базе:
            """;

    public static final String MANAGER_MENU_TICKET_UPDATE = """
            Кабинет менеджера/Фильмы/Список фильмов/Обновление сеанса
            
            Обновление сеанса фильма в базе:
            """;

    //  ========== Меню USER ==========
    public static final String USER_MENU = """
            Кабинет пользователя
            
            Выберите необходимый пункт меню:
            1. Фильмы
            2. Билеты
            3. Личный счет
            0. Выход
            
            ввод:\s""";

    //  ========== Меню USER/Film ==========
    public static final String USER_FILM = """
            Кабинет пользователя/Фильмы
            
            Выберите необходимый пункт меню:
            1. Просмотреть список фильмов
            0. Выход
            
            ввод:\s""";

    public static final String USER_FILM_VALIDATION_PAYMENT_TICKET = """
            Кабинет пользователя/Фильмы/Расписание сеансов/Места/Покупка
            
            Выберите необходимый пункт меню:
            1. Подтвердить покупку билета
            0. Выход
            
            ввод:\s""";

    //  ========== Меню USER/Tickets ==========
    public static final String USER_TICKETS = """
            Кабинет пользователя/Билеты
            
            Выберите необходимый пункт меню:
            1. Просмотреть список купленных билетов:
            0. Выход
            
            ввод:\s""";

    //  ========== Меню USER/Balance ==========
    public static final String USER_BALANCE = """
            Кабинет пользователя/Баланс счета
            
            Баланс Вашего счета составляет:\s""";

    private ConsoleMenuConstant() {
    }
}
