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

    @Override
    public void add(User user) {
        UserDAO1 userDAO = (UserDAO1) context.getBean("UserDAOJdbcImpl");
        userDAO.add(user);
    }

    @Override
    public void delete(Integer id) {
        UserDAO1 userDAO = (UserDAO1) context.getBean("UserDAOJdbcImpl");
        userDAO.delete(id);
    }

    @Override
    public void edit(User user) {
        UserDAO1 userDAO = (UserDAO1) context.getBean("UserDAOJdbcImpl");
        userDAO.update(user);
    }

    @Override
    public List<User> getAll() {
        UserDAO1 userDAO = (UserDAO1) context.getBean("UserDAOJdbcImpl");
        return userDAO.getAll();
    }
}
