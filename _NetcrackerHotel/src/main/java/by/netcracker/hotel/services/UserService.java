package by.netcracker.hotel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import by.netcracker.hotel.dto.UserDTO;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;

/**
 * Created by Alexander on 06.04.2017.
 */
@Service
public interface UserService<User, Integer> extends AbstractService<User, Integer> {
	void registerUser(User user) throws UsernameExistException, EmailExistException;

	List<User> getAll();

	User getUserByUsername(String username);

	UserDTO convert(User user);

	User convert(UserDTO user);

	boolean update(UserDTO dto);

	void blockUser(User user);
}
