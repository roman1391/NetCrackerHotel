package by.netcracker.hotel.services;

import org.springframework.stereotype.Service;

/**
 * Created by slava on 02.04.17.
 */
public interface AbstractService<E, ID> {
    E getByID(ID id);
}
