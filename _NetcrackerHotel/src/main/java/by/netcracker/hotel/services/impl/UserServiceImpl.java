package by.netcracker.hotel.services.impl;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import by.netcracker.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.exceptions.UserNotFoundException;

import java.sql.SQLException;
import java.util.List;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService<User, Integer> {

    private WebApplicationContext context;
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(WebApplicationContext context, UserDAO userDAO) {
        this.context = context;
        this.userDAO = userDAO;
    }

    public void registerUser(User user) throws UsernameExistException, EmailExistException {
        if (usernameExist(user.getUsername())) {
            throw new UsernameExistException("Account with username - " + user.getUsername() +
                    " are exist");
        } else if (emailExist(user.getEmail())) {
            throw new EmailExistException("Account with email - " + user.getEmail() + " are exist");
        } else {
            userDAO.add(user);
        }
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userDAO.getAll();
    }

    private boolean usernameExist(String username) {
        User user = null;
        user = userDAO.getByUsername(username);
        return user != null;
    }

    private boolean emailExist(String email) {
        User user = null;
        user = userDAO.getByEmail(email);
        return user != null;
    }
}
