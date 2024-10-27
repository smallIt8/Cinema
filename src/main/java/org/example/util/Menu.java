package org.example.util;

import org.example.controller.PersonController;
import org.example.repository.*;
import org.example.service.*;

public class Menu {
    public static void start() {
        PersonRepository personRepository = new PersonRepositoryImpl();
        FilmRepository filmRepository = new FilmRepositoryImpl();
        TicketRepository ticketRepository = new TicketRepositoryImpl();
        TicketService ticketService = new TicketServiceImpl(ticketRepository);
        FilmService filmService = new FilmServiceImpl(filmRepository, ticketService);
        PersonService personService = new PersonServiceImpl(personRepository, filmService, ticketService);
        PersonController personController = new PersonController(personService);
        personController.welcomePerson();
    }

    public Menu() {
    }
}


