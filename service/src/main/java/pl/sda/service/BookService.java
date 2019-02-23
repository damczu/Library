package pl.sda.service;

import pl.sda.domain.model.Book;
import pl.sda.persistance.repository.BookRepository;
import pl.sda.service.exception.BookAlreadyExistsException;

import java.time.LocalDate;
import java.util.List;

public class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public Integer addBook(String title, String isbnNumber, LocalDate releaseDate, String summary,List<Integer> authors) throws BookAlreadyExistsException {
        if(isbnExists(isbnNumber)) {
            throw new BookAlreadyExistsException(title, isbnNumber);
        }
        Book book = new Book();
        book.setTitle(title);
        book.setIsbnNumber(isbnNumber);
        book.setReleaseDate(releaseDate);
        book.setSummary(summary);

        book.setAuthors(authorService.findAuthors(authors));

        return bookRepository.save(book);
    }

    private boolean isbnExists(String isbnNumber) {
        List<Book> book = bookRepository.findByIsbn(isbnNumber);
        if(book.size() > 0){
            return true;
        }
        return false;
    }
}
