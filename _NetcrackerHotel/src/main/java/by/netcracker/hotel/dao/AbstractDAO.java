package by.netcracker.hotel.dao;

import java.util.List;

/**
 * Created by slava on 02.04.17.
 */
public interface AbstractDAO<E, ID> {
    void add(E entity);

    void deleteByID(ID id);

    void update(E entity);

    E getByID(ID id);

    List<E> getAll();
}
