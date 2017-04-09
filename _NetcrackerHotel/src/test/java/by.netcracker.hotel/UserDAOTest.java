package by.netcracker.hotel;

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

/**
 * Created by slava on 09.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-test/root-context.xml", "/spring-test/mysql-datasource.xml", "/spring-test/servlet-context.xml"})
@WebAppConfiguration
public class UserDAOTest {

    @Autowired
    private WebApplicationContext context;
    private UserDAOJdbcImpl userDAO;
    private User expected;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Before
    public void setUp(){
        userDAO = (UserDAOJdbcImpl) context.getBean("UserDAOJdbcImpl");
    }

    @Test
    public void testAdd() throws Exception{
        expected = EntityBuilder.buildUser("Test","Test","test",
                "12345","test@gmail.com");
        userDAO.add(expected);
        User actual = userDAO.getByUsername(expected.getUsername());
        if(passwordEncoder.matches(expected.getPassword(),actual.getPassword())){
            actual.setPassword(expected.getPassword());
        }
        userDAO.deleteByUsername(actual.getUsername());
        expected.setId(actual.getId());
        Assert.assertEquals(expected,actual);
    }
}
