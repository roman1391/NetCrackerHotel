package by.netcracker.hotel.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.dao.OrderDAO;
import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.services.OrderService;
import by.netcracker.hotel.utils.SearchFilter;

/**
 * Created by Alexander on 25.04.2017.
 */
@Service("orderServiceImpl")
@SessionScope
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;
    private final HotelDAO hotelDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO, HotelDAO hotelDAO) {
        this.orderDAO = orderDAO;
        this.hotelDAO = hotelDAO;
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
