package pl.sda.persistance.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.domain.model.Person;
import pl.sda.persistance.hibernate.HibernateUtil;

import java.util.List;

public class PersonRepository {

    private final Session session;

    public PersonRepository() {
        this.session = HibernateUtil.getSession();
    }

    public Person findById(Integer personId) {
        return session.get(Person.class, personId);
    }

    public Integer save(Person person){
        Transaction tx = session.beginTransaction();
        Integer resultId = (Integer) session.save(person);
        tx.commit();
        return resultId;
    }

    public Person findByID(Integer personId) {
        return session.get(Person.class, personId);
    }

    public void update(Person person) {
        Transaction tx = session.beginTransaction();
        session.update(person);
        tx.commit();
    }

    public void delete(Person person) {
        Transaction tx = session.beginTransaction();
        session.delete(person);
        tx.commit();
    }

    public List<Person> findByEmail(String email) {

        return session.createQuery("FROM Person WHERE email = '" + email + "'").list();

    }
}
