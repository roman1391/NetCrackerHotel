package by.netcracker.hotel.services.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import by.netcracker.hotel.filter.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import by.netcracker.hotel.dao.OrderDAO;
import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.services.OrderService;

/**
 * Created by Alexander on 25.04.2017.
 */
@Service("OrderServiceImpl")
@SessionScope
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public Order getByID(Integer id) {
        return orderDAO.getByID(id);
    }

    @Override
    public void addOrder(Order order) {
        orderDAO.add(order);
    }

    @Override
    public List<Order> getByUserId(int userId) {
        return orderDAO.getByUserId(userId);
    }

    @Override
    public void deleteByOrderId(int orderId) {
        orderDAO.deleteByID(orderId);
    }

    @Override
    public void update(int id, SearchFilter searchFilter) {
        orderDAO.update(id, searchFilter);
    }

}
