package pl.sda.persistance.repository;

import org.hibernate.Session;
import pl.sda.domain.model.User;

public class UserRepository {
    private final Session session;

    public UserRepository(Session session) {
        this.session = session;
    }

    public Integer save(User user){
        return (Integer) session.save(user);
    }

    public User findByID(Integer userId) {
        return session.get(User.class, userId);
    }

    public void update(User user) {
        session.update(user);
    }

    public void delete(User user) {
        session.delete(user);
    }

}
