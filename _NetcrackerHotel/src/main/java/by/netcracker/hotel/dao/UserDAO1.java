package by.netcracker.hotel.dao;

import by.netcracker.hotel.entities.User;

/**
 * Created by slava on 02.04.17.
 */
public interface UserDAO1 extends AbstractDAO<User, Integer> {
    User getByEmail(String email);

    User getByUsername(String username);
}
