package by.netcracker.hotel.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.exceptions.UserNotFoundException;

@Service("UserServiceImpl")
public class UserServiceImpl {

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
}
