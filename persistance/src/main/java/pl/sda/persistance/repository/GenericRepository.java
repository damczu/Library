package pl.sda.persistance.repository;

import org.hibernate.Session;

public abstract class GenericRepository<T , K>{
    protected final Session session;
    protected final Class<T> entityClass;

    public GenericRepository(Session session, Class<T> entityClass) {
        this.session = session;
        this.entityClass = entityClass;
    }




    public Integer save(T object){
        return (Integer) session.save(object);
    }

    public void update(T object) {
        session.update(object);
    }

    public void delete(T object) {
        session.delete(object);
    }

    public T findByID(Integer id) {
        return session.get(entityClass, id);
    }

}
