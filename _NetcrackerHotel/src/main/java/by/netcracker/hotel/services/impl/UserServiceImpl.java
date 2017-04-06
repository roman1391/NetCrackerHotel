package by.netcracker.hotel.services.impl;

import by.netcracker.hotel.dao.UserDAO1;
import by.netcracker.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.exceptions.UserNotFoundException;

import java.util.List;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService<User, Integer> {

	@Autowired
	private WebApplicationContext context;

	public void registerUser(User user) {
		UserDAO userDAO = (UserDAO) context.getBean("UserDAOJdbcTemplateImpl");
		userDAO.createUser(user);
	}

	public void loginUser(User user) throws UserNotFoundException {
		UserDAO userDAO = (UserDAO) context.getBean("UserDAOJdbcTemplateImpl");
		userDAO.readUser(user);
		if (user.getAccessLevel() == 0) {
			throw new UserNotFoundException();
		}
	}

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
