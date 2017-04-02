package by.netcracker.hotel.services;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by slava on 02.04.17.
 */
@Service
public interface AbstractService<E,ID> {
    void add(E entity);
    void delete(ID id);
    E edit(E entity);
    List<E> getAll();
}
