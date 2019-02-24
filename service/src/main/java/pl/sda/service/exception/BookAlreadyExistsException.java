package pl.sda.service.exception;

public class BookAlreadyExistsException extends Exception {
    public BookAlreadyExistsException(String title, String isbnNumber) {
        super("ISBN: " + isbnNumber + " already exists. Cannot add \"" + title + "\".");
    }
}
