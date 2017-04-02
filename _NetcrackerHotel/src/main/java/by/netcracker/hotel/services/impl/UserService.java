package by.netcracker.hotel.services.impl;

import by.netcracker.hotel.dao.UserDAO1;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by slava on 02.04.17.
 */

@Service
public class UserService implements AbstractService<User,Integer> {

    private UserDAO1 userDAO;

    public UserService(UserDAO1 userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(User user) {
        userDAO.add(user);
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public User editUser(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
