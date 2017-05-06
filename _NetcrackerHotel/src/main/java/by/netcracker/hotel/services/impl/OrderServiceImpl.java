package by.netcracker.hotel.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.netcracker.hotel.dao.OrderDAO;
import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.services.OrderService;

/**
 * Created by Alexander on 25.04.2017.
 */
@Service("OrderServiceImpl")
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

    public void findByUserId(Integer id) {

    }
}
