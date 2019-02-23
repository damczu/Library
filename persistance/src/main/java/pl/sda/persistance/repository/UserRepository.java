package pl.sda.persistance.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.domain.model.User;
import pl.sda.persistance.hibernate.HibernateUtil;

public class UserRepository {
    private final Session session;

    public UserRepository() {
        this.session = HibernateUtil.getSession();
    }

    public Integer save(User user){
        Transaction tx = session.beginTransaction();
        Integer userId = (Integer) session.save(user);
        tx.commit();
        return userId;
    }

    public User findByID(Integer userId) {
        return session.get(User.class, userId);
    }

    public void update(User user) {
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
    }

    public void delete(User user) {
        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
    }

}
