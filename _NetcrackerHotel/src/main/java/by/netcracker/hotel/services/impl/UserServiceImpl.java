package by.netcracker.hotel.services.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.dao.VerificationTokenDAO;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.VerificationToken;
import by.netcracker.hotel.enums.ROLE;
import by.netcracker.hotel.exceptions.EmailExistException;
import by.netcracker.hotel.exceptions.UsernameExistException;
import by.netcracker.hotel.services.UserService;

@Service("userServiceImpl")
@SessionScope
public class UserServiceImpl implements UserService {

    private static Logger log = Logger.getLogger(UserServiceImpl.class);

    private UserDAO userDAO;
    private VerificationTokenDAO tokenDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, VerificationTokenDAO tokenDAO) {
        this.userDAO = userDAO;
        this.tokenDAO = tokenDAO;
    }

    public UserServiceImpl() {
        super();
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
    @PreAuthorize("hasRole('ADMIN')")
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
    @PreAuthorize("hasRole('ADMIN')")
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

    // updating of users by admin
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void fullUpdate(User user) throws UsernameExistException, EmailExistException {
        User oldUser = userDAO.getByID(user.getId());
        // if (user.getUsername() == null)
        // return;
        if (!user.getUsername().equals(oldUser.getUsername()) && usernameExist(user.getUsername())) {
            throw new UsernameExistException();
        } else if (!user.getEmail().equals(oldUser.getEmail()) && emailExist(user.getEmail())) {
            throw new EmailExistException();
        } else {
            userDAO.update(user);
        }
    }

    @Override
    public void profileUpdate(User user) throws UsernameExistException, EmailExistException {
        User existUser = userDAO.getByID(user.getId());
        if (!user.getUsername().equals(existUser.getUsername()) && usernameExist(user.getUsername())) {
            throw new UsernameExistException("Account with username - " + user.getUsername() + " are exist");
        } else if (!user.getEmail().equals(existUser.getEmail()) && emailExist(user.getEmail())) {
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
            log.warn("Exception in userService while user updating", e);
            return false;
        }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void blockUser(User user) {
        user = getUserByUsername(user.getUsername());
        user.setAuthority(ROLE.BLOCKED);
        update(user);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
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

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
