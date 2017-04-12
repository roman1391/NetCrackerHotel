package by.netcracker.hotel.services.impl;

import java.util.List;

import by.netcracker.hotel.enums.ROLE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.dto.UserDTO;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import by.netcracker.hotel.services.UserService;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService<User, Integer> {

	private UserDAO userDAO;

	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void registerUser(User user) throws UsernameExistException, EmailExistException {
		if (usernameExist(user.getUsername())) {
			throw new UsernameExistException("Account with username - " + user.getUsername() + " are exist");
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
		return userDAO.getByUsername(username) != null;
	}

	private boolean emailExist(String email) {
		return userDAO.getByEmail(email) != null;
	}

	@Override
	public User getUserByUsername(String username) {
		return userDAO.getByUsername(username);
	}

	@Override
	public boolean update(UserDTO entity) {
		try {
			userDAO.update(entity.toObject());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void blockUser(User user) {
		user = getUserByUsername(user.getUsername());
		user.setAuthority(ROLE.BLOCKED);
		update(user.toDTO());
	}

	@Override
	public void unblockUser(User user) {
		user = getUserByUsername(user.getUsername());
		user.setAuthority(ROLE.USER);
		update(user.toDTO());
	}

}
