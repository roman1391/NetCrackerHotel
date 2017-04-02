package by.netcracker.hotel.services.impl;

import by.netcracker.hotel.dao.UserDAO1;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * Created by slava on 02.04.17.
 */

@Service("UserService")
public class UserService implements AbstractService<User,Integer> {

    private WebApplicationContext context;
    private final UserDAO1 userDAO = (UserDAO1) context.getBean("UserDAOJdbcImpl");

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void delete(Integer id) {
        userDAO.delete(id);
    }

    @Override
    public void edit(User user) {
        userDAO.update(user);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }
}
