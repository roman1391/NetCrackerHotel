package by.netcracker.hotel.dao;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.exceptions.UserNotFoundException;

import java.sql.SQLException;

/**
 * Created by slava on 02.04.17.
 */
public interface UserDAO extends AbstractDAO<User, Integer> {
    User getByEmail(String email) throws SQLException;

    User getByUsername(String username) throws SQLException;
}
