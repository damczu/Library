package pl.sda.persistance.repository;

import org.hibernate.Session;
import pl.sda.domain.model.Book;

import java.util.List;

public class BookRepository {
    private final Session session;

    public BookRepository(Session session, Book book){
        this.session = session;
    }

    public Integer update(Book book){
        return(Integer) session.save(book);
    }

    public Book find(int bookId){
        return session.find(Book.class, bookId);
    }

    public void delete(Book book){
        session.delete(book);
    }

    public List<Book> findAll(){
        return session
                .createQuery("FROM Books")
                .list();
    }

}
