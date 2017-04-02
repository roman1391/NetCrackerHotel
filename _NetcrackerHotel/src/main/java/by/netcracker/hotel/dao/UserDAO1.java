package by.netcracker.hotel.dao;

import java.util.List;
import by.netcracker.hotel.entities.User;

/**
 * Created by slava on 02.04.17.
 */
public interface UserDAO1 extends AbstractDAO<User,Integer>{

    @Override
    default void add(User entity) {
    }

    @Override
    default User update(User entity) {
        return null;
    }

    @Override
    default User getByID(Integer ID) {
        return null;
    }

    @Override
    default List<User> getAll() {
        return null;
    }

    User getByEmail(String email);
    User getByUsername(String username);
}
