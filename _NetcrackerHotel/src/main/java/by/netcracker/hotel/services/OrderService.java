package by.netcracker.hotel.services;

import java.util.List;

import by.netcracker.hotel.entities.Order;
import by.netcracker.hotel.utils.SearchFilter;

/**
 * Created by Alexander on 25.04.2017.
 */
public interface OrderService extends AbstractService<Order, Integer> {
    void addOrder(Order order);

    List<Order> getByUserId(int userId);

    void deleteByOrderId(int orderId);

    void update(int id, SearchFilter searchFilter);

}
