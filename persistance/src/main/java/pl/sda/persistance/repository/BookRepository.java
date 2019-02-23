package pl.sda.persistance.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.domain.model.Book;
import pl.sda.persistance.hibernate.HibernateUtil;

import java.util.List;

public class BookRepository {
    private final Session session;

    public BookRepository(Session session){
        this.session = HibernateUtil.getSession();
    }

    public Integer save(Book book){
        Transaction tx = session.beginTransaction();
        Integer bookId = (Integer) session.save(book);
        tx.commit();
        return bookId;
    }

    public Book find(int bookId){
        return session.find(Book.class, bookId);
    }

    public void delete(Book book){
        Transaction tx = session.beginTransaction();
        session.delete(book);
        tx.commit();
    }

    public List<Book> findAll(){
        return session
                .createQuery("FROM Book")
                .list();
    }

    public List<Book> findByIsbn(String isbnNumber) {
        return session
                .createQuery("FROM Book WHERE BOK_IsbnNumber = '" + isbnNumber + "'" )
                .list();
    }
}
