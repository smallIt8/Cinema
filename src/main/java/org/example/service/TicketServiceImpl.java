package org.example.service;

import org.example.model.*;
import org.example.repository.TicketRepository;
import org.example.util.Utils;
import org.example.util.constant.RegexConstant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.exception.CinemaExceptionMessage.*;
import static org.example.util.constant.ColorsConstant.*;
import static org.example.util.constant.ConsoleMenuConstant.*;
import static org.example.util.constant.StepConstant.*;

public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private Role userRole;
    private final Scanner SCANNER = new Scanner(System.in);
    private final LocalDate minDate = LocalDate.now().plusDays(1);
    private final LocalDate maxDate = LocalDate.now().plusDays(30);
    private LocalDate date;
    private LocalTime time;

    @Override
    public void create(Film film) {
        try {
            List<LocalDateTime> dateTimes = enterDateTime();
            for (LocalDateTime dateTime : dateTimes) {
                Long price;
                System.out.println(CREATION_TICKET_MESSAGE + INDIGO + dateTime + RESET);
                System.out.print(ENTER_TICKET_PRICE);
                price = Long.parseLong(SCANNER.nextLine());
                List<Ticket> tickets = new ArrayList<>();
                try {
                    for (Seat seat : Seat.values()) {
                        Ticket ticket = new Ticket(film, seat, price, dateTime);
                        tickets.add(ticket);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
                try {
                    ticketRepository.create(tickets);
                    System.out.println(CREATED_TICKET_MESSAGE + INDIGO + dateTime + RESET);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public LocalDateTime update(LocalDateTime selectedSession, Film selectedFilm) {
        selectFilmSessionUpdate(selectedSession, selectedFilm);

        System.out.println("Ой, данное меню в разработке...");
        return selectedSession;
    }

    @Override
    public List<LocalDateTime> getSessionsFilm(Film selectedFilm) {
        List<LocalDateTime> sessions;
        try {
            sessions = ticketRepository.getAllSessionsByFilmId(selectedFilm.getId());
            if (!sessions.isEmpty()) {
                try {
                    System.out.println(LIST_FILM_SESSIONS_MESSAGE);
                    for (int i = 0; i < sessions.size(); i++) {
                        LocalDateTime session = sessions.get(i);
                        String numberOfSession = Utils.colorizeNumber(session.toString(), i + 1);
                        System.out.println(numberOfSession);
                    }
                    System.out.print(SELECT_SESSION_OR_EXIT);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
                Utils.loopIterationAndExit((int count) -> {
                    try {
                        String step = SCANNER.nextLine();
                        switch (step) {
                            case STEP_ONE -> selectSession(sessions, selectedFilm);
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
            } else {
                System.out.println(EMPTY_LIST_SESSIONS_MESSAGE);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return sessions;
    }

    @Override
    public void selectedSeat(Film selectedFilm, LocalDateTime selectedSession) {
        List<Seat> seats = getListSeatFilm(selectedFilm, selectedSession);
        System.out.println(SELECT_SEAT_OR_EXIT);
        Utils.loopIterationAndExit((int count) -> {
            try {
                String step = SCANNER.nextLine();
                switch (step) {
                    case STEP_ONE -> entrySeat(seats, selectedFilm, selectedSession);
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

    @Override
    public void purchaseTicket(Seat selectedSeat, Film selectedFilm, LocalDateTime selectedSession) {
        System.out.println(PURCHASING_TICKET_FILM_MESSAGE);
        System.out.println(SELECTED_FILM_MESSAGE + INDIGO + selectedFilm.getFilmName() + RESET);
        System.out.println(SELECTED_SESSION_MESSAGE + INDIGO + selectedSession.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm")) + RESET);
        System.out.println(SELECTED_SEAT_MESSAGE + INDIGO + selectedSeat.getNumber() + RESET);
        System.out.println(USER_FILM_VALIDATION_PAYMENT_TICKET);
        Utils.loopIterationAndExit((int count) -> {
            try {
                String step = SCANNER.nextLine();
                switch (step) {
                    case STEP_ONE -> System.out.println("Ой, данное меню в разработке...");
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
        System.out.println(BUYING_TICKET_MESSAGE);
    }

    @Override
        public List<Seat> getListSeatFilm(Film selectedFilm, LocalDateTime selectedSession) {
            try {
                List<Seat> seats = ticketRepository.getListSeatSessionFilm(selectedFilm.getId(), selectedSession);
                if (!seats.isEmpty()) {
                    try {
                        System.out.println(LIST_FILM_SEATS_MESSAGE);
                        for (int i = 0; i < seats.size(); i++) {
                            Seat seat = seats.get(i);
                            String seatNumberStr = String.valueOf(seat.getNumber());
                            String numberOfFilm = Utils.colorizeNumber(seatNumberStr, i + 1);
                            System.out.println(numberOfFilm);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
            return null;
    }

    @Override
    public void refund() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void entrySeat(List<Seat> seats, Film selectedFilm, LocalDateTime selectedSession) {
        try {
            for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
                System.out.print(ENTER_SEAT_NUMBER);
                String step = SCANNER.nextLine();
                if (step.matches(RegexConstant.STEP_REGEX)) {
                    try {
                        for (int i2 = 1; i2 <= seats.size(); i2++) {
                            String currentNumber = String.valueOf(i2);
                            if (step.equals(currentNumber)) {
                                Seat selectedSeat = seats.get(i2 - 1);
                                System.out.println(SELECTED_SEAT_MESSAGE + INDIGO + selectedSeat.getNumber() + RESET);
                                purchaseTicket(selectedSeat, selectedFilm, selectedSession);
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

    private void selectSession(List<LocalDateTime> sessions, Film selectedFilm) {
        try {
            for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
                System.out.print(ENTER_SESSION_NUMBER);
                String step = SCANNER.nextLine();
                if (step.matches(RegexConstant.STEP_REGEX)) {
                    try {
                        for (int i2 = 1; i2 <= sessions.size(); i2++) {
                            String currentNumber = String.valueOf(i2);
                            if (step.equals(currentNumber)) {
                                LocalDateTime selectedSession = sessions.get(i2 - 1);
                                System.out.println(SELECTED_SESSION_MESSAGE + INDIGO + selectedSession.toString() + RESET);
                                roleDefinition(selectedSession, selectedFilm);
                                break;
                            }
                        }
                        if (i < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.println(ERROR_ENTER_SESSION_NUMBER_MESSAGE);
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

    private void roleDefinition(LocalDateTime selectedSession, Film selectedFilm) {
        try {
            switch (userRole) {
                case ADMIN, MANAGER:
                    update(selectedSession, selectedFilm);
                    break;
                case USER:
                    selectedSeat(selectedFilm, selectedSession);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private List<LocalDateTime> enterDateTime() {
        List<LocalDateTime> dateTimes = new ArrayList<>();
        boolean isRunning = true;

        while (isRunning) {
            try {
                enterDate();
                System.out.println(LIST_FILM_TIMES_MESSAGE);
                selectTime();
                LocalDateTime dateTime = LocalDateTime.of(date, time);
                if (checkingGetDateTime(dateTimes, dateTime)) {
                    dateTimes.add(dateTime);
                    System.out.println(SELECTED_FILM_DATE_TIME_MESSAGE + INDIGO + dateTime + RESET);
                    if (!createSessionsFilm()) {
                        isRunning = false;
                    }
                } else {
                    System.out.println(ERROR_ADD_FILM_DATE_TIME_MESSAGE);
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return dateTimes;
    }

    private void enterDate() {
        try {
            for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
                System.out.print(ENTER_FILM_DATE);
                String enterDate = SCANNER.nextLine();
                try {
                    date = LocalDate.parse(enterDate, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
                    if (date.isBefore(minDate) || date.isAfter(maxDate)) {
                        if (i < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.println(ERROR_ENTER_FILM_DATE_MESSAGE);
                        } else {
                            Utils.exitByFromAttempts();
                        }
                    } else {
                        break;
                    }
                } catch (DateTimeParseException e) {
                    if (i < Utils.ITERATION_LOOP_MESSAGE) {
                        System.out.println(ERROR_ENTER_FILM_FORMAT_DATE_MESSAGE);
                    } else {
                        Utils.exitByFromAttempts();
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void selectTime() {
        try {
            Time[] arrTimes = Time.values();
            if (arrTimes.length > 0) {
                for (int i = 0; i < arrTimes.length; i++) {
                    Time times = arrTimes[i];
                    String numberOfTime = Utils.colorizeNumber(times.getTimeName().toString(), i + 1);
                    System.out.println(numberOfTime);
                }
                selectTimeNumber(arrTimes);
            } else {
                System.out.println(EMPTY_LIST_FILMS_TIME_MESSAGE);
                Utils.exit();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void selectTimeNumber(Time[] arrTimes) {
        try {
            System.out.print(ENTER_FILM_TIME);
            for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
                String step = SCANNER.nextLine();
                if (step.matches(RegexConstant.STEP_REGEX)) {
                    boolean timeFound = false;
                    try {
                        for (int i2 = 1; i2 <= arrTimes.length; i2++) {
                            String currentNumber = String.valueOf(i2);
                            if (step.equals(currentNumber)) {
                                Time selectedTime = arrTimes[i2 - 1];
                                time = selectedTime.getTimeName();
                                timeFound = true;
                                break;
                            }
                        }
                        if (timeFound) {
                            break;
                        } else {
                            if (i < Utils.ITERATION_LOOP_MESSAGE) {
                                System.out.println(ERROR_ENTER_FILM_TIME_NUMBER_MESSAGE);
                            } else {
                                Utils.exitByFromAttempts();
                            }
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
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private boolean checkingGetDateTime(List<LocalDateTime> dateTimes, LocalDateTime dateTime) {
        return !dateTimes.contains(dateTime) && !ticketRepository.checkDateTime(dateTime);
    }

    private boolean createSessionsFilm() {
        boolean addSession = false;
        try {
            System.out.print(TICKET_ADD_OR_RETURN);
            for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
                String step = SCANNER.nextLine().trim();
                switch (step) {
                    case STEP_ONE:
                        addSession = true;
                        break;
                    case STEP_ZERO:
                        return false;
                    default:
                        if (i < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.print(ERROR_ENTER_MESSAGE);
                        } else {
                            Utils.exitByFromAttempts();
                        }
                }
                if (addSession) {
                    break;
                }
            }
        } catch (DateTimeParseException e) {
            throw new RuntimeException(e.getMessage());
        }
        return addSession;
    }

    private void selectFilmSessionUpdate(LocalDateTime oldDateTime, Film selectedFilm) {
        List<LocalDateTime> allDateTimes = new ArrayList<>(getSessionsFilm(selectedFilm));
        allDateTimes.remove(oldDateTime);
        List<LocalDateTime> newDateTimes = enterDateTime();
        for (LocalDateTime dateTime : newDateTimes) {
            if (!allDateTimes.contains(dateTime)) {
                allDateTimes.add(dateTime);
            }
        }
    }

    @Override
    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
}
