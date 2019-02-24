package pl.sda.service;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.persistance.repository.BookRepository;
import pl.sda.service.exception.BookAlreadyExistsException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookServiceTest {
    @Test
    public void shouldAddNewBook() throws BookAlreadyExistsException {
        //given
        String title = "Mroczna wieża";
        String isbnNumber = "111";
        LocalDate releaseDate = LocalDate.parse("2019-01-01");
        String summary = "good book";
        BookService bookService = new BookService(new BookRepository(), new AuthorService());
        List<Integer> authorId = new ArrayList<>();
        authorId.add(1);
        //when
        Integer bookId = bookService.addBook(title,isbnNumber,releaseDate,summary,authorId);
        //then
        Assert.assertNotNull(bookId);
    }
}
