package pl.sda.persistance.repository;

import org.hibernate.Session;
import pl.sda.domain.model.Author;

public class AuthorRepository {
    private final Session session;

    public AuthorRepository(Session session) {
        this.session = session;
    }

    public Integer save(Author author){
        return (Integer) session.save(author);
    }


}
