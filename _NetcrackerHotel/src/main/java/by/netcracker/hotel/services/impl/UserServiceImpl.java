package by.netcracker.hotel.services.impl;

import java.util.Date;
import java.util.List;

import by.netcracker.hotel.dao.VerificationTokenDAO;
import by.netcracker.hotel.entities.VerificationToken;
import by.netcracker.hotel.enums.ROLE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.dto.UserDTO;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import by.netcracker.hotel.services.UserService;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService<User, Integer> {

	private UserDAO userDAO;
	private VerificationTokenDAO tokenDAO;

	@Autowired
	public UserServiceImpl(UserDAO userDAO,VerificationTokenDAO tokenDAO) {
		this.userDAO = userDAO;
		this.tokenDAO = tokenDAO;
	}

	public User registerUser(User user) throws UsernameExistException, EmailExistException {
		if (usernameExist(user.getUsername())) {
			throw new UsernameExistException("Account with username - " + user.getUsername() + " are exist");
		} else if (emailExist(user.getEmail())) {
			throw new EmailExistException("Account with email - " + user.getEmail() + " are exist");
		} else {
			userDAO.add(user);
			return userDAO.getByUsername(user.getUsername());
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
	public User getByID(Integer id) {
		return userDAO.getByID(id);
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

	@Override
	public void createVerificationToken(int id, String token) {
		VerificationToken verificationToken = new VerificationToken(token,id,new Date());
		tokenDAO.add(verificationToken);
	}

	@Override
	public VerificationToken getVerificationToken(String token) {
         return tokenDAO.getByToken(token);
	}

	@Override
	public void saveRegisteredUser(User user) {
		userDAO.update(user);
	}

	@Override
	public User getByVerificationToken(String token) {
		return userDAO.getByID(tokenDAO.getByToken(token).getUserID());
	}
}
