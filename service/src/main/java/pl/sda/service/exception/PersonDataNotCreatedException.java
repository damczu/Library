package pl.sda.service.exception;

public class PersonDataNotCreatedException extends Exception {
    public PersonDataNotCreatedException() {
        super("Person data has not been created.");
    }
}
