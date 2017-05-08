package by.netcracker.hotel.dao.impl;

import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import by.netcracker.hotel.dao.VerificationTokenDAO;
import by.netcracker.hotel.entities.VerificationToken;

/**
 * Created by slava on 15.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-test/root-context.xml", "/spring-test/mysql-datasource.xml",
        "/spring-test/servlet-context.xml" })
@WebAppConfiguration
public class VerificationTokenDAOTest {
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private VerificationTokenDAO verificationTokenDAO;
    private VerificationToken expected;

    @Before
    public void setUp() {
        expected = new VerificationToken(UUID.randomUUID().toString(), 10, new Date());
    }

    @Test
    public void testAdd() {
        verificationTokenDAO.add(expected);
        VerificationToken actual = verificationTokenDAO.getByToken(expected.getToken());
        expected.setId(actual.getId());
        verificationTokenDAO.deleteByID(actual.getId());
        Assert.assertEquals(expected, actual);
    }

}
