package pl.sda.web;

import pl.sda.service.PersonService;

public class PersonServlet {

    private final PersonService personService;

    public PersonServlet() {
        this.personService = new PersonService();
    }
}
