package by.netcracker.hotel.services;

import java.util.List;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.VerificationToken;
import org.springframework.stereotype.Service;

import by.netcracker.hotel.dto.UserDTO;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;

/**
 * Created by Alexander on 06.04.2017.
 */
public interface UserService<User, Integer> extends AbstractService<User, Integer> {
	User registerUser(User user) throws UsernameExistException, EmailExistException;

	List<User> getAll();

	User getUserByUsername(String username);

	boolean update(UserDTO dto);

	void blockUser(User user);

	void unblockUser(User user);

	void createVerificationToken(int id, String token);

	VerificationToken getVerificationToken(String token);

	User getByVerificationToken(String token);

	void saveRegisteredUser(User user);
}
