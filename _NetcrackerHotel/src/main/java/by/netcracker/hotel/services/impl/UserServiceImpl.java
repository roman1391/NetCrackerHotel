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

import java.util.List;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService<User, Integer> {

	@Autowired
	private WebApplicationContext context;
    @Autowired
	private UserDAO userDAO;

	public void registerUser (User user) throws UsernameExistException, EmailExistException {
        if(usernameExist(user.getUsername())){
        	throw new UsernameExistException("Account with username - "+user.getUsername()+
			          " are exist");
		} else if(emailExist(user.getEmail())) {
			throw new EmailExistException("Account with email - " + user.getEmail() + " are exist");
		} else {
           userDAO.add(user);
		}
	}


	public User loginUser(User user) throws UserNotFoundException {
		userDAO.getByUsername(user.getUsername());
		if (user.getAccessLevel() == 0) {
			throw new UserNotFoundException();
		}
		return null;
	}

	private boolean usernameExist(String username){
		User user = userDAO.getByUsername(username);
		if(user!=null){
			return true;
		}
		return false;
	}

	private boolean emailExist(String email){
		User user = userDAO.getByEmail(email);
		if(user!=null){
			return true;
		}
		return false;
	}
}
