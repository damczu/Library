package pl.sda.persistance.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.domain.model.Author;
import pl.sda.persistance.hibernate.HibernateUtil;

public class AuthorRepository {
    private final Session session;

    public AuthorRepository() {
        this.session = HibernateUtil.getSession();
    }

    public Integer save(Author author){
        Transaction tx = session.beginTransaction();
        Integer authorId = (Integer) session.save(author);
        tx.commit();
        return authorId;
    }

}
