package pl.sda.service;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.persistance.repository.BookRepository;
import pl.sda.service.exception.BookAlreadyExistsException;

import java.time.LocalDate;

public class BookServiceTest {
    @Test
    public void shouldAddNewBook() throws BookAlreadyExistsException {
        //given
        String title = "Mroczna wieża";
        String isbnNumber = "111";
        LocalDate releaseDate = LocalDate.parse("2019-01-01");
        String summary = "good book";
        BookService bookService = new BookService(new BookRepository());
        //when
        Integer bookId = bookService.addBook(title,isbnNumber,releaseDate,summary);
        //then
        Assert.assertNotNull(bookId);
    }
}
