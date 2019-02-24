package pl.sda.service;

import pl.sda.domain.model.Category;
import pl.sda.domain.model.dto.BookDtoFactory;
import pl.sda.domain.model.Book;
import pl.sda.domain.model.dto.BookDto;
import pl.sda.persistance.repository.BookRepository;
import pl.sda.service.exception.BookAlreadyExistsException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService implements BookServiceInterface {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public Integer addBook(BookDto bookDto) throws BookAlreadyExistsException {
        if (isbnExists(bookDto.isbn)) {
            throw new BookAlreadyExistsException(bookDto.title, bookDto.isbn);
        }
        Book book = new Book();
        book.setTitle(bookDto.title);
        book.setIsbnNumber(bookDto.isbn);
        book.setReleaseDate(LocalDate.now());
        book.setSummary("");
        book.setCategory(bookDto.category);
        book.setAuthors(authorService.findAuthors(bookDto.authorIdList));

        return bookRepository.save(book);
    }

    private boolean isbnExists(String isbnNumber) {
        List<Book> book = bookRepository.findByIsbn(isbnNumber);
        if (book.size() > 0) {
            return true;
        }
        return false;
    }

    public Integer count() {
        return bookRepository.count();
    }

    private List<Book> getOffset(int offset, int limit) {
        return bookRepository.findByOffset(offset, limit);
    }

    private List<BookDto> getBooksDto(List<Book> books) {
        return books.stream()
                .map(x -> new BookDtoFactory().create(x))
                .collect(Collectors.toList());
    }

    public List<BookDto> getBooksDtoWithOffset(int offset, int limit) {
        List<Book> books = getOffset(offset, limit);
        return getBooksDto(books);
    }

}
