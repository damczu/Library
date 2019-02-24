package pl.sda.service;

import pl.sda.domain.model.dto.BookDto;
import pl.sda.service.exception.BookAlreadyExistsException;

public interface BookServiceInterface {

    Integer addBook(BookDto bookDto) throws BookAlreadyExistsException;
}
