package by.netcracker.hotel;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.dao.constant.UserRole;
import by.netcracker.hotel.dao.impl.UserDAOJdbcImpl;
import by.netcracker.hotel.entities.EntityBuilder.EntityBuilder;
import by.netcracker.hotel.entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by slava on 09.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-test/root-context.xml",
                                   "/spring-test/mysql-datasource.xml",
                                   "/spring-test/servlet-context.xml"})
@WebAppConfiguration
public class UserDAOTest {

    @Autowired
    private WebApplicationContext context;
    private UserDAO userDAO;
    private User expected;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Before
    public void setUp(){
        userDAO = (UserDAOJdbcImpl) context.getBean("UserDAOJdbcImpl");
        expected = EntityBuilder.buildUser("Test","Test","test",
                "12345","test@gmail.com",true, UserRole.ROLE_USER.getRole());
    }

    @Test
    public void testAdd() throws Exception{
        userDAO.add(expected);
        User actual = userDAO.getByUsername(expected.getUsername());
        if(passwordEncoder.matches(expected.getPassword(),actual.getPassword())){
            actual.setPassword(expected.getPassword());
        }
        expected.setId(actual.getId());
        userDAO.deleteByID(actual.getId());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testDeleteByUsername() throws Exception{
        userDAO.add(expected);
        userDAO.deleteByUsername(expected.getUsername());
        User actual = userDAO.getByUsername(expected.getUsername());
        Assert.assertNull(actual);
    }

    @Test
    public void testGetAll() throws Exception{
        List<User> expected = userDAO.getAll();
        int size = 10;
        for(int i = 0; i<size; i++){
            User user = EntityBuilder.buildUser("Test","Test","test"+i,
                    "12345","test@gmail.com",true, UserRole.ROLE_USER.getRole());
            expected.add(user);
            userDAO.add(user);
        }
        List<User> actual = userDAO.getAll();
        int i=0;
        for (User user: actual) {
            if(passwordEncoder.matches(expected.get(i).getPassword(),user.getPassword())){
                user.setPassword(expected.get(i).getPassword());
                expected.set(i,user);
                actual.set(i,user);
            }
            i++;
        }
          Assert.assertArrayEquals(expected.toArray(),actual.toArray());
        for (User user: actual) {
            userDAO.deleteByID(user.getId());
        }
    }

    @Test
    public void testUpdate() throws Exception{
        userDAO.add(expected);
        expected = userDAO.getByUsername(expected.getUsername());
        User changes = EntityBuilder.buildUser("update","update","update",
                "123456","update@gmail.com",false, UserRole.ROLE_ADMIN.getRole());
        changes.setId(expected.getId());
        userDAO.update(changes);
        User actual = userDAO.getByID(changes.getId());
        if(passwordEncoder.matches(changes.getPassword(),actual.getPassword())){
            actual.setPassword(changes.getPassword());
        }
        userDAO.deleteByID(actual.getId());
        Assert.assertEquals(changes,actual);
    }
}
