package pl.sda.service.exception;

public class LoginExistsException extends Exception {
    public LoginExistsException(String login) {
        super("Login: " + login + " already exists");
    }
}
