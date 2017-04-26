package by.netcracker.hotel.dao;

import by.netcracker.hotel.entities.Order;

import java.util.List;

/**
 * Created by Alexander on 25.04.2017.
 */
public interface OrderDAO extends AbstractDAO<Order, Integer> {
    List<Order> getByUserId(int userId);
}
