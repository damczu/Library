package pl.sda.persistance.repository;

import org.hibernate.Session;
import pl.sda.domain.model.Person;

public class PersonRepository {

    private final Session session;

    public PersonRepository(Session session) {
        this.session = session;
    }

    public Integer save(Person person){
        return (Integer) session.save(person);
    }

    public Person findByID(Integer personId) {
        return session.get(Person.class, personId);
    }

    public void update(Person person) {
        session.update(person);
    }

    public void delete(Person person) {
        session.delete(person);
    }
}
