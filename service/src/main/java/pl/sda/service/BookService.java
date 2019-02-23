package pl.sda.service;

import pl.sda.domain.model.Book;
import pl.sda.persistance.repository.BookRepository;

import java.time.LocalDate;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Integer addBook(String title, String isbnNumber, LocalDate releaseDate, String summary){
        Book book = new Book();
        book.setTitle(title);
        book.setIsbnNumber(isbnNumber);
        book.setReleaseDate(releaseDate);
        book.setSummary(summary);

        return bookRepository.save(book);
    }
}
