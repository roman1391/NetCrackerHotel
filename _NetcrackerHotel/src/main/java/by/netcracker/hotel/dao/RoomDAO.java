package by.netcracker.hotel.dao;

import by.netcracker.hotel.entities.Room;

import java.util.List;

/**
 * Created by Varvara on 4/25/2017.
 */
public interface RoomDAO extends AbstractDAO<Room, Integer> {
    List<Room> getByHotelID(int hotelID);
}
