package pl.sda.service;

import pl.sda.service.exception.BookAlreadyExistsException;

import java.time.LocalDate;
import java.util.List;

public interface BookServiceInterface {

    Integer addBook(String title, String isbnNumber, LocalDate releaseDate, String summary, List<Integer> authors) throws BookAlreadyExistsException;
}
