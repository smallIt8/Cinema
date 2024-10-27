package org.example.service;

import org.example.model.Person;
import org.example.model.Role;
import org.example.repository.PersonRepository;
import org.example.util.Utils;
import org.example.util.constant.RegexConstant;

import java.util.*;

import static org.example.exception.CinemaExceptionMessage.*;
import static org.example.util.constant.ConsoleMenuConstant.*;
import static org.example.util.constant.StepConstant.*;

public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final FilmService filmService;
    private final TicketService ticketService;
    private final Scanner SCANNER = new Scanner(System.in);
    private String userName;
    private String email;
    private String password;

    @Override
    public void entry() {
        System.out.println(ENTRY_MESSAGE);
        Utils.loopIterationAndExit((int count) -> {
            System.out.print(ENTER_USERNAME);
            String userName = SCANNER.nextLine().toLowerCase();
            System.out.print(ENTER_PASSWORD);
            String password = SCANNER.nextLine();
            Optional<Person> person = personRepository.entry(userName, password);
            if (person.isPresent()) {
                Role role = person.get().getRole();
                filmService.setUserRole(role);
                ticketService.setUserRole(role);
                if (role == Role.ADMIN) {
                    adminMenu();
                } else if (role == Role.MANAGER) {
                    managerMenu();
                } else if (role == Role.USER) {
                    userMenu();
                }
                System.out.println(WELCOME_MESSAGE + userName);
            } else {
                if (count < Utils.ITERATION_LOOP_MESSAGE) {
                    System.out.println(ERROR_ENTER_USER_NAME_OR_PASSWORD_MESSAGE);
                }
            }
        }, Utils.ITERATION_LOOP);
    }

    @Override
    public void adminMenu() {
        System.out.print(ADMIN_MENU);
        Utils.loopIterationAndExit((int count) -> {
            String step = SCANNER.nextLine();
            switch (step) {
                case STEP_ONE -> filmService.adminFilm();
                case STEP_TWO -> filmService.getAll();
                case STEP_ZERO -> Utils.exit();
                default -> {
                    if (count < Utils.ITERATION_LOOP_MESSAGE) {
                        System.out.print(ERROR_ENTER_MESSAGE);
                    }
                }
            }
        }, Utils.ITERATION_LOOP);
    }

    @Override
    public void managerMenu() {
        System.out.print(MANAGER_MENU);
        Utils.loopIterationAndExit((int count) -> {
            String step = SCANNER.nextLine();
            switch (step) {
                case STEP_ONE -> filmService.managerFilm() ;
                case STEP_TWO -> filmService.getAll();
                case STEP_THREE -> System.out.println(FINISHING_MESSAGE);
                case STEP_ZERO -> Utils.exit();
                default -> {
                    if (count < Utils.ITERATION_LOOP_MESSAGE) {
                        System.out.println(ERROR_ENTER_MESSAGE);
                    }
                }
            }
        }, Utils.ITERATION_LOOP);
    }

    @Override
    public void userMenu() {
        System.out.print(USER_MENU);
        Utils.loopIterationAndExit((int count) -> {
            String step = SCANNER.nextLine();
            switch (step) {
                case STEP_ONE -> filmService.userfilm();
                case STEP_TWO -> System.out.println();
                case STEP_THREE -> System.out.println(" ");
                case STEP_ZERO -> Utils.exit();
                default -> {
                    if (count < Utils.ITERATION_LOOP_MESSAGE) {
                        System.out.println(ERROR_ENTER_MESSAGE);
                    }
                }
            }
        }, Utils.ITERATION_LOOP);
    }

    @Override
    public void create() {
        System.out.println(REGISTRATION_MESSAGE);
        createUserName();
        createPassword();
        createEmail();
        Person person = new Person(UUID.randomUUID(), userName.toLowerCase(), password, email.toLowerCase());
        try {
            personRepository.create(person);
            System.out.println(REGISTERED_MESSAGE);
            entry();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Person> getAll() {
        return personRepository.getAll();
    }

    @Override
    public Optional<Person> getById(UUID id) {
        return personRepository.getById(id);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public Person updateById(UUID id, Person person) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    private void createUserName() {
        for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
            System.out.print(ENTER_USERNAME);
            userName = SCANNER.nextLine();
            try {
                if (userName.matches(RegexConstant.USERNAME_REGEX)) {
                    if (personRepository.checkUserName(userName)) {
                        if (i < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.println(ERROR_CREATION_USER_NAME_MESSAGE);
                        } else {
                            Utils.exitByFromAttempts();
                        }
                    } else {
                        break;
                    }
                } else {
                    if (i < Utils.ITERATION_LOOP_MESSAGE) {
                        System.out.println(ERROR_ENTER_USER_NAME_MESSAGE);
                    } else {
                        Utils.exitByFromAttempts();
                    }
                }
            } catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    private void createPassword() {
        for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
            System.out.print(ENTER_PASSWORD);
            password = SCANNER.nextLine();
            if (!password.matches(RegexConstant.PASSWORD_REGEX)) {
                if (i < Utils.ITERATION_LOOP_MESSAGE) {
                    System.out.println(ERROR_ENTER_PASSWORD_MESSAGE);
                } else {
                    Utils.exitByFromAttempts();
                }
            } else {
                break;
            }
        }
    }

    private void createEmail() {
        for (int i = 0; i < Utils.ITERATION_LOOP; i++) {
            System.out.print(ENTER_EMAIL);
            email = SCANNER.nextLine();
            try {
                if (email.matches(RegexConstant.EMAIL_REGEX)) {
                    if (personRepository.checkEmail(email)) {
                        if (i < Utils.ITERATION_LOOP_MESSAGE) {
                            System.out.println(ERROR_CREATION_EMAIL_MESSAGE);
                        } else {
                            Utils.exitByFromAttempts();
                        }
                    } else {
                        break;
                    }
                } else {
                    if (i < Utils.ITERATION_LOOP_MESSAGE) {
                        System.out.println(ERROR_ENTER_EMAIL_MESSAGE);
                    } else {
                        Utils.exitByFromAttempts();
                    }
                }
            } catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public PersonServiceImpl(PersonRepository personRepository, FilmService filmService, TicketService ticketService) {
        this.personRepository = personRepository;
        this.filmService = filmService;
        this.ticketService = ticketService;
    }
}