package by.netcracker.hotel.dao.impl;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import by.netcracker.hotel.entities.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-test/root-context.xml", "/spring-test/mysql-datasource.xml",
        "/spring-test/servlet-context.xml" })
@WebAppConfiguration
public class OrderDAOImplTest {

    @Autowired
    private OrderDAOImpl orderDAO;
    private List<Order> list;
    private Order order;

    @Before
    public void setup() {
        order = new Order(7000, 7001, 7002, new Date(), new Date(), 0, "testFirstName", "testLastName", "testUser",
            "testHotel");
    }

    @Test
    public void addTest() {
        orderDAO.add(order);
        list = orderDAO.getByUserId(order.getUserId());
        Order newOrder = list.get(0);
        order.setId(newOrder.getId());
        orderDAO.deleteByID(newOrder.getId());
        assertTrue(order.equals(newOrder));
    }

    @Test
    public void deleteByIDTest() {
        orderDAO.add(order);
        list = orderDAO.getByUserId(order.getUserId());
        Order newOrder = list.get(0);
        order.setId(newOrder.getId());
        orderDAO.deleteByID(newOrder.getId());
        newOrder = orderDAO.getByID(newOrder.getId());
        assertNull(newOrder);
    }

    @Test
    public void getByIdTest() {
        orderDAO.add(order);
        list = orderDAO.getByUserId(order.getUserId());
        Order newOrder = list.get(0);
        order = null;
        order = orderDAO.getByID(newOrder.getId());
        orderDAO.deleteByID(newOrder.getId());
        assertTrue(order.equals(newOrder));
    }

}
