package by.netcracker.hotel.services;

import by.netcracker.hotel.entities.Order;

/**
 * Created by Alexander on 25.04.2017.
 */
public interface OrderService extends AbstractService<Order, Integer> {
    void addOrder(Order order);
}
