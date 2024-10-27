package org.example.service;

import org.example.model.Film;
import org.example.model.Role;
import org.example.repository.FilmRepository;
import org.example.util.Utils;
import org.example.util.constant.RegexConstant;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static org.example.exception.CinemaExceptionMessage.*;
import static org.example.util.constant.ColorsConstant.*;
import static org.example.util.constant.ConsoleMenuConstant.*;
import static org.example.util.constant.StepConstant.*;

public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final TicketService ticketService;
    private Role userRole;
    private final Scanner SCANNER = new Scanner(System.in);
    private String filmName = "";
    private String year = "";
    private String country = "";
    private String description = "";

    @Override
    public void adminFilm() {
        try {
            System.out.print(ADMIN_MENU_FILM);
            Utils.loopIterationAndExit((int count) -> {
                String step = SCANNER.nextLine();
                switch (step) {
                    case STEP_ONE -> {
                        create();
                        System.out.print(ADMIN_MENU_FILM);
                    }
                    case STEP_TWO -> {
                        getAll();
                        System.out.print(ADMIN_MENU_FILM);
                    }
                    case STEP_THREE -> {
                        System.out.println();//update();

                        System.out.print(ADMIN_MENU_FILM);
                    }
                    case STEP_FOUR -> {
                        System.out.println();//delete();

                        System.out.print(ADMIN_MENU_FILM);
                    }
                    case STEP_ZERO -> Utils.exit();
                    default -> {
                        if (count < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.print(ERROR_ENTER_MESSAGE);
                        }
                    }
                }
            }, Utils.ITERATION_LOOP);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void managerFilm() {
        try {
            System.out.print(MANAGER_FILM);
            Utils.loopIterationAndExit((int count) -> {
                String step = SCANNER.nextLine();
                switch (step) {
                    case STEP_ONE -> getAll();
                    case STEP_ZERO -> Utils.exit();
                    default -> {
                        if (count < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.print(ERROR_ENTER_MESSAGE);
                        }
                    }
                }
            }, Utils.ITERATION_LOOP);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void userfilm() {
        try {
            System.out.print(USER_FILM);
            Utils.loopIterationAndExit((int count) -> {
                String step = SCANNER.nextLine();
                switch (step) {
                    case STEP_ONE -> {
                        getAll();
                        System.out.print(USER_FILM);
                    }
                    case STEP_ZERO -> Utils.exit();
                    default -> {
                        if (count < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.print(ERROR_ENTER_MESSAGE);
                        }
                    }
                }
            }, Utils.ITERATION_LOOP);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void create() {
        try {
            System.out.print(ADMIN_MENU_FILM_ADD);
            enterFilmName();
            enterYearFilm();
            enterCountryFilm();
            enterDescriptionFilm();
            Film film = new Film(filmName, year, country, description);
            try {
                filmRepository.create(film);
                System.out.println(CREATED_FILM_MESSAGE);
                ticketService.create(film);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void getAll() {
            List<Film> films = filmRepository.getAll();
            if (!films.isEmpty()) {
                try {
                    System.out.println(LIST_FILMS_MESSAGE);
                    for (int i = 0; i < films.size(); i++) {
                        Film film = films.get(i);
                        String numberOfFilm = Utils.colorizeNumber(film.toString(), i + 1);
                        System.out.println(numberOfFilm);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            } else {
                System.out.println(EMPTY_LIST_FILMS_MESSAGE);
            }
        selectedFilm(films);
    }

    @Override
    public Optional<Film> getById(Integer id) {
        try {
            return Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Film update(Film selectedFilm) {
        try {
            switch (userRole) {
                case ADMIN:
                    System.out.println(ADMIN_MENU_FILM_UPDATE);
                    break;
                case MANAGER:
                    System.out.println(MANAGER_MENU_FILM_UPDATE);
                    break;
            }
            enterFilmNameUpdate(selectedFilm);
            enterYearFilmUpdate(selectedFilm);
            enterCountryFilmUpdate(selectedFilm);
            enterDescriptionFilmUpdate(selectedFilm);
            try {
                filmRepository.update(selectedFilm);
                System.out.println(FILM_UPDATE_MESSAGE);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
            switch (userRole) {
                case ADMIN:
                    adminFilm();
                    break;
                case MANAGER:
                    managerFilm();
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return selectedFilm;
    }

    @Override
    public Film updateById(Integer id, Film film) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    private void selectedFilm(List<Film> films) {
        System.out.print(SELECT_FILM_OR_EXIT);
        Utils.loopIterationAndExit((int count) -> {
            try {
                String step = SCANNER.nextLine();
                switch (step) {
                    case STEP_ONE -> entryFilm(films);
                    case STEP_ZERO -> Utils.exit();
                    default -> {
                        if (count < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.print(ERROR_ENTER_MESSAGE);
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }, Utils.ITERATION_LOOP);
    }

    private void entryFilm(List<Film> films) {
        try {
            for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
                System.out.print(ENTER_FILM_NUMBER);
                String step = SCANNER.nextLine();
                if (step.matches(RegexConstant.STEP_REGEX)) {
                    try {
                        for (int i2 = 1; i2 <= films.size(); i2++) {
                            String currentNumber = String.valueOf(i2);
                            if (step.equals(currentNumber)) {
                                Film selectedFilm = films.get(i2 - 1);
                                System.out.println(SELECTED_FILM_MESSAGE + INDIGO + selectedFilm.getFilmName() + RESET);
                                roleDefinition(selectedFilm);
                                break;
                            }
                        }
                        if (i < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.println(ERROR_ENTER_FILM_NUMBER_MESSAGE);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                    }
                } else {
                    if (i < Utils.ITERATION_LOOP_MESSAGE) {
                        System.out.println(ERROR_ENTER_MESSAGE);
                    }
                }
            }
            Utils.exitByFromAttempts();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void roleDefinition(Film selectedFilm) {
        try {
            switch (userRole) {
                case ADMIN, MANAGER:
                    System.out.print(FILM_UPDATE_OR_EXIT);
                    Utils.loopIterationAndExit((int count) -> {
                        try {
                            String stepAdmin = SCANNER.nextLine();
                            switch (stepAdmin) {
                                case STEP_ONE -> update(selectedFilm);
                                case STEP_TWO -> updateSessionFilm(selectedFilm);
                                case STEP_ZERO -> Utils.exit();
                                default -> {
                                    if (count < Utils.ITERATION_LOOP_MESSAGE) {
                                        System.out.print(ERROR_ENTER_MESSAGE);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e.getMessage());
                        }
                    }, Utils.ITERATION_LOOP);
                    break;
                case USER:
                    ticketService.getSessionsFilm(selectedFilm);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void updateSessionFilm(Film selectedFilm) {
        try {
            System.out.print(TICKET_UPDATE_OR_EXIT);
            Utils.loopIterationAndExit((int count) -> {
                try {
                    String step = SCANNER.nextLine();
                    switch (step) {
                        case STEP_ONE -> {
                            ticketService.getSessionsFilm(selectedFilm);
                            System.out.print(TICKET_UPDATE_OR_EXIT);
                        }
                        case STEP_TWO -> {
                            ticketService.create(selectedFilm);
                            System.out.print(TICKET_UPDATE_OR_EXIT);
                        }
                        case STEP_ZERO -> Utils.exit();
                        default -> {
                            if (count < Utils.ITERATION_LOOP_MESSAGE) {
                                System.out.print(ERROR_ENTER_MESSAGE);
                            }
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }, Utils.ITERATION_LOOP);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private String enterFilmNameUniversal(String promptMessage, boolean checkUniqueFilmName) {
        String universal = null;
        try {
            for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
                System.out.print(promptMessage);
                try {
                    universal = SCANNER.nextLine();
                    if (universal.matches(RegexConstant.FILM_NAME)) {
                        if (!checkUniqueFilmName || !filmRepository.checkFilmName(universal)) {
                            break;
                        } else {
                            if (i < Utils.ITERATION_LOOP_MESSAGE) {
                                System.out.println(ERROR_CREATION_FILM_NAME_MESSAGE);
                            } else {
                                Utils.exitByFromAttempts();
                            }
                        }
                    } else {
                        if (i < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.print(ERROR_ENTER_FILM_NAME_MESSAGE);
                        } else {
                            Utils.exitByFromAttempts();
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return universal;
    }

    private void enterFilmName() {
        filmName = enterFilmNameUniversal(
                ENTER_FILM_NAME,
                true
        );
    }

    private void enterFilmNameUpdate(Film selectedFilm) {
        filmName = enterFilmNameUniversal(
                ENTER_FILM_NAME_UPDATE,
                false);
        selectedFilm.setFilmName(filmName);
    }

    private String enterYearFilmUniversal(String promptMessage) {
        String universal = null;
        try {
            for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
                System.out.print(promptMessage);
                try {
                    universal = SCANNER.nextLine();
                    if (universal.matches(RegexConstant.YEAR)) {
                        break;
                    } else {
                        if (i < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.print(ERROR_ENTER_FILM_YEAR_MESSAGE);
                        } else {
                            Utils.exitByFromAttempts();
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return universal;
    }

    private void enterYearFilm() {
        year = enterYearFilmUniversal(ENTER_FILM_YEAR);
    }

    private void enterYearFilmUpdate(Film selectedFilm) {
        year = enterYearFilmUniversal(ENTER_FILM_YEAR_UPDATE);
        selectedFilm.setYear(year);
    }

    private String enterCountryFilmUniversal(String promptMessage) {
        String universal = null;
        try {
            for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
                System.out.print(promptMessage);
                try {
                    universal = SCANNER.nextLine();
                    if (universal.matches(RegexConstant.COUNTRY)) {
                        break;
                    } else {
                        if (i < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.print(ERROR_ENTER_FILM_COUNTRY_MESSAGE);
                        } else {
                            Utils.exitByFromAttempts();
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return universal;
    }

    private void enterCountryFilm() {
        country = enterCountryFilmUniversal(ENTER_FILM_COUNTRY);
    }

    private void enterCountryFilmUpdate(Film selectedFilm) {
        country = enterCountryFilmUniversal(ENTER_FILM_COUNTRY_UPDATE);
        selectedFilm.setCountry(country);
    }

    private String enterDescriptionFilmUniversal(String promptMessage) {
        String universal = null;
        try {
            for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
                System.out.print(promptMessage);
                try {
                    universal = SCANNER.nextLine();
                    if (universal.matches(RegexConstant.DESCRIPTION)) {
                        break;
                    } else {
                        if (i < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.print(ERROR_ENTER_FILM_DESCRIPTION_MESSAGE);
                        } else {
                            Utils.exitByFromAttempts();
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return universal;
    }

    private void enterDescriptionFilm() {
        description = enterDescriptionFilmUniversal(ENTER_FILM_DESCRIPTION);
    }

    private void enterDescriptionFilmUpdate(Film selectedFilm) {
        description = enterDescriptionFilmUniversal(ENTER_FILM_DESCRIPTION_UPDATE);
        selectedFilm.setDescription(description);
    }

    @Override
    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public FilmServiceImpl(FilmRepository filmRepository, TicketService ticketService) {
        this.filmRepository = filmRepository;
        this.ticketService = ticketService;
    }
}