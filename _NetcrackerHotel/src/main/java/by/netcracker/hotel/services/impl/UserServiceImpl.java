package by.netcracker.hotel.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.entities.User;

@Service("UserServiceImpl")
public class UserServiceImpl {

	@Autowired
	private WebApplicationContext context;

	public void registerUser(User user) {
		UserDAO userDAO = (UserDAO) context.getBean("UserDAOJdbcTemplateImpl");
		userDAO.createUser(user);
	}

	public void loginUser(User user) {
		UserDAO userDAO = (UserDAO) context.getBean("UserDAOJdbcTemplateImpl");
		userDAO.readUser(user);
	}
}
