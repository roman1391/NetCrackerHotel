package by.netcracker.hotel.services;

import java.util.List;

import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.VerificationToken;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;

/**
 * Created by Alexander on 06.04.2017.
 */

public interface UserService extends AbstractService<User, Integer> {
    User registerUser(User user) throws UsernameExistException, EmailExistException;

    User addEnabledUser(User user) throws UsernameExistException, EmailExistException;

    List<User> getAll();

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    boolean update(User user);

    void blockUser(User user);

    void unblockUser(User user);

    void createVerificationToken(int id, String token);

    VerificationToken getVerificationToken(String token);

    User getByVerificationToken(String token);

    void deleteVerificationToken(Integer id);

    void saveRegisteredUser(User user);

    void deleteUserByUsername(String username);

    List<String> getUsernames();

    void changeUserPassword(User user, String password);

    void profileUpdate(User user) throws UsernameExistException, EmailExistException;

    void fullUpdate(User user) throws UsernameExistException, EmailExistException;
}
