package pl.sda.domain.model.dto;

import pl.sda.domain.model.Book;
import pl.sda.domain.model.dto.BookDto;

public class BookDtoFactory {

    public BookDto create(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.title = book.getTitle();
        bookDto.isbn = book.getIsbnNumber();
        bookDto.author = book.getAuthorNames();
        bookDto.category = book.getCategory();

        return bookDto;
    }
}
