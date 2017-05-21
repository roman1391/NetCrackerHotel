package by.netcracker.hotel.services.impl;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.entities.User;

public class UserServiceImplTest {

    @Mock
    UserDAO userDAO;
    private User user = new User();
    private UserServiceImpl userService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl();
        userService.setUserDAO(userDAO);
    }

    @Test
    public void getUserByEmailTest() {
        userService.getUserByEmail(user.getEmail());
        verify(userDAO).getByEmail(user.getEmail());
    }

    @Test
    public void getAllTest() {
        userService.getAll();
        verify(userDAO).getAll();
    }

    @Test
    public void getUserByUsernameTest() {
        userService.getUserByUsername(user.getUsername());
        verify(userDAO).getByUsername(user.getUsername());
    }

    @Test
    public void getByIDTest() {
        userService.getByID(user.getId());
        verify(userDAO).getByID(user.getId());
    }

}
