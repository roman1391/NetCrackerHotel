package by.netcracker.hotel.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.dao.VerificationTokenDAO;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.VerificationToken;
import by.netcracker.hotel.enums.ROLE;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import by.netcracker.hotel.services.UserService;
import org.springframework.web.context.annotation.SessionScope;

@Service("UserServiceImpl")
@SessionScope
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    private VerificationTokenDAO tokenDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, VerificationTokenDAO tokenDAO) {
        this.userDAO = userDAO;
        this.tokenDAO = tokenDAO;
    }

    @Override
    public User registerUser(User user) throws UsernameExistException, EmailExistException {
        if (usernameExist(user.getUsername())) {
            throw new UsernameExistException("Account with username - " + user.getUsername() + " are exist");
        } else if (emailExist(user.getEmail())) {
            throw new EmailExistException("Account with email - " + user.getEmail() + " are exist");
        } else {
            user.setAuthority(ROLE.USER);
            user.setEnabled(false);
            userDAO.add(user);
            return userDAO.getByUsername(user.getUsername());
        }
    }

    @Override
    public User addEnabledUser(User user) throws UsernameExistException, EmailExistException {
        if (usernameExist(user.getUsername())) {
            throw new UsernameExistException("Account with username - " + user.getUsername() + " are exist");
        } else if (emailExist(user.getEmail())) {
            throw new EmailExistException("Account with email - " + user.getEmail() + " are exist");
        } else {
            user.setEnabled(true);
            userDAO.add(user);
            return userDAO.getByUsername(user.getUsername());
        }
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
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
    public void fullUpdate(User user) throws UsernameExistException, EmailExistException {
        User oldUser = userDAO.getByID(user.getId());
        // if (user.getUsername() == null)
        // return;
        if (!user.getUsername().equals(oldUser.getUsername()) && usernameExist(user.getUsername())) {
            System.out.println("exist!");
            throw new UsernameExistException();
        } else if (!user.getEmail().equals(oldUser.getEmail()) && emailExist(user.getEmail())) {
            throw new EmailExistException();
        } else {
            userDAO.update(user);
        }
    }

    @Override
    public void profileUpdate(User user) throws UsernameExistException, EmailExistException {
        if (usernameExist(user.getUsername())) {
            throw new UsernameExistException("Account with username - " + user.getUsername() + " are exist");
        } else if (emailExist(user.getEmail())) {
            throw new EmailExistException("Account with email - " + user.getEmail() + " are exist");
        } else {
            userDAO.update(user);
        }
    }

    @Override
    public boolean update(User entity) {
        try {
            userDAO.update(entity);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void blockUser(User user) {
        user = getUserByUsername(user.getUsername());
        user.setAuthority(ROLE.BLOCKED);
        update(user);
    }

    @Override
    public void unblockUser(User user) {
        user = getUserByUsername(user.getUsername());
        user.setAuthority(ROLE.USER);
        update(user);
    }

    @Override
    public void createVerificationToken(int id, String token) {
        VerificationToken verificationToken = new VerificationToken(token, id, new Date());
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
    public void deleteVerificationToken(Integer id) {
        tokenDAO.deleteByID(id);
    }

    @Override
    public User getByVerificationToken(String token) {
        return userDAO.getByID(tokenDAO.getByToken(token).getUserID());
    }

    @Override
    public void deleteUserByUsername(String username) {
        userDAO.deleteByUsername(username);
    }

    @Override
    public List<String> getUsernames() {
        return userDAO.getUsernames();
    }

    @Override
    public void changeUserPassword(User user, String password) {
        userDAO.userPasswordUpdate(user, password);
    }
}
