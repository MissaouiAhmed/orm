    package fr.polytech.orm.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

/**
 *
 * @author Missaoui
 * @param <T>
 * @param <PK>
 */
public class GenericDaoImpl<T, PK extends Serializable>
        implements GenericDao<T, PK> {

    protected Class<T> entityClass;

    public GenericDaoImpl() {
        this.entityClass = (Class<T>) getClass();
    }

    @Override
    public void create(T t, EntityManager e) {
        e.persist(t);
    }

    @Override
    public T read(PK id, EntityManager e) {
        return e.find(entityClass, id);
    }

    @Override
    public T update(T t, EntityManager e) {
        return e.merge(t);
    }

    @Override
    public void delete(T t, EntityManager e) {
        t = e.merge(t);
        e.remove(t);
    }
}
