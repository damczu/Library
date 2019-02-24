package pl.sda.service;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.domain.model.Category;
import pl.sda.domain.model.dto.BookDto;
import pl.sda.domain.model.dto.BookDtoFactory;
import pl.sda.persistance.repository.BookRepository;
import pl.sda.service.exception.BookAlreadyExistsException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookServiceTest {
    @Test
    public void shouldAddNewBook() throws BookAlreadyExistsException {
        //given
        BookDto bookDto = new BookDto();

        bookDto.title = "Mroczna wieża";
        bookDto.isbn = "111";
        //LocalDate releaseDate = LocalDate.parse("2019-01-01");
//        bookDto.summary = "good book";
        bookDto.category = Category.THILLER;
        BookService bookService = new BookService(new BookRepository(), new AuthorService());
        List<Integer> authorId = new ArrayList<>();
        authorId.add(1);
        bookDto.authorIdList = authorId;
        //when
        Integer bookId = bookService.addBook(bookDto);
        //then
        Assert.assertNotNull(bookId);
    }
}
