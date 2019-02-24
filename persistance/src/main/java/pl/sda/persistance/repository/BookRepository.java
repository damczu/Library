package pl.sda.persistance.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.internal.SessionFactoryBuilderImpl;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import pl.sda.domain.model.Book;
import pl.sda.persistance.hibernate.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookRepository {
    private final Session session;

    public BookRepository(){
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
                .createQuery("FROM Book WHERE isbnNumber = '" + isbnNumber + "'" )
                .list();
    }

    public Integer count() {
        return ((Integer) session.createQuery("select count(*) from Book").uniqueResult()).intValue();
    }

    public List<Book> findByOffset(int offset, int limit) {
        return session.createQuery("FROM Books OFFSET " + offset + "LIMIT " + limit).list();

    }
}
