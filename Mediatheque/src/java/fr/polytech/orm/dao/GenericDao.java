package fr.polytech.orm.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author Missaoui
 */
public interface GenericDao<T, PK extends Serializable> {

    void create(T t, EntityManager e);

    T read(PK id, EntityManager e);

    T update(T t, EntityManager e);

    void delete(T t, EntityManager e);
}
