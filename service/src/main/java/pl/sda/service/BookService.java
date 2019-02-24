package pl.sda.service;

import BookDtoFactory.BookDtoFactory;
import pl.sda.domain.model.Book;
import pl.sda.domain.model.dto.BookDto;
import pl.sda.persistance.repository.BookRepository;
import pl.sda.service.exception.BookAlreadyExistsException;

import java.time.LocalDate;
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

    public Integer count(){
        return bookRepository.count();
    }

    public List<Book> getOffset(int offset, int limit){
        return bookRepository.findByOffset(offset, limit);
    }

    public List<BookDto> getBooksDto(List<Book> books){
        return books.stream()
                .map(x -> new BookDtoFactory().create(x))
                .collect(Collectors.toList());
    }
}
