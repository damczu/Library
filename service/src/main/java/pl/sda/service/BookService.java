package pl.sda.service;

import pl.sda.domain.model.Book;
import pl.sda.persistance.repository.BookRepository;
import pl.sda.service.exception.BookAlreadyExistsException;

import java.time.LocalDate;
import java.util.List;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Integer addBook(String title, String isbnNumber, LocalDate releaseDate, String summary) throws BookAlreadyExistsException {
        if(isbnExists(isbnNumber)) {
            throw new BookAlreadyExistsException(title, isbnNumber);
        }
        Book book = new Book();
        book.setTitle(title);
        book.setIsbnNumber(isbnNumber);
        book.setReleaseDate(releaseDate);
        book.setSummary(summary);

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
