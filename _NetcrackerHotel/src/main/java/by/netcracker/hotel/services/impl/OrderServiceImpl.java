package by.netcracker.hotel.services.impl;

import by.netcracker.hotel.dao.OrderDAO;
import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Alexander on 25.04.2017.
 */
@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }
    @Override
    public Order getByID(Integer integer) {
        return null;
    }

    @Override
    public void addOrder(Order order) {
        orderDAO.add(order);
    }

    public void findByUserId(Integer id){

    }
}
