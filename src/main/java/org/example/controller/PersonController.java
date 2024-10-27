package org.example.controller;

import org.example.service.PersonService;
import org.example.util.Utils;

import java.util.Scanner;
import java.util.UUID;

import static org.example.exception.CinemaExceptionMessage.ERROR_ENTER_MESSAGE;
import static org.example.util.constant.ConsoleMenuConstant.*;
import static org.example.util.constant.StepConstant.*;

public class PersonController {
    private final PersonService personService;
    private static final Scanner SCANNER = new Scanner(System.in);

    public void welcomePerson() {
        System.out.print(MAIN_MENU);
        Utils.loopIterationAndExit((int count) -> {
            try {
                String step = SCANNER.nextLine();
                switch (step) {
                    case STEP_ONE -> personService.entry();
                    case STEP_TWO -> personService.create();
                    case STEP_ZERO -> Utils.exit();
                    default -> {
                        if (count < Utils.ITERATION_LOOP_MESSAGE)
                            System.out.print(ERROR_ENTER_MESSAGE);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }, Utils.ITERATION_LOOP);
    }

    public void getById() {
        UUID id = UUID.randomUUID();

        personService.getById(id).ifPresent(person ->
                System.out.println(person.getUserName()));
    }

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
}