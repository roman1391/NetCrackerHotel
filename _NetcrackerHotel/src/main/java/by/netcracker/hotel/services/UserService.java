package by.netcracker.hotel.services;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UserNotFoundException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alexander on 06.04.2017.
 */
@Service
public interface UserService<User, Integer> extends AbstractService<User, Integer> {
    void registerUser (User user) throws UsernameExistException, EmailExistException;
    List<User> getAll();
}
