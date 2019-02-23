package pl.sda.persistance.repository;

import org.hibernate.Session;

public abstract class GeneralRepository <T, K>{
    protected final Session session;
    protected final Class<T> entityClass;

    public GeneralRepository(Session session, Class<T> entityClass) {
        this.session = session;
        this.entityClass = entityClass;
    }

    public Integer save(T object){
        return (Integer) session.save(object);
    }
}
