package pl.sda.persistance.repository;

import org.hibernate.Session;
import pl.sda.domain.model.Book;

public class BookRepository {
    private final Session session;
    private final Book book;

    public BookRepository(Session session, Book book){
        this.session = session;
        this.book = book;
    }


}
