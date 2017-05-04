package by.netcracker.hotel.services;

import by.netcracker.hotel.entities.Order;

import java.util.List;

/**
 * Created by Alexander on 25.04.2017.
 */
public interface OrderService extends AbstractService<Order, Integer> {
    void addOrder(Order order);

    List<Order> getByUserId(int userId);

    void deleteByOrderId(int orderId);
}
