package by.netcracker.hotel.dao;

import by.netcracker.hotel.entities.User;

public interface UserDAO {

    void createUser(User user);

    User readUser(User user);

    void updateUser(User user);

}
