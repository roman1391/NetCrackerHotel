package by.netcracker.hotel.dao;

import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.utils.SearchFilter;

import java.util.Date;
import java.util.List;

/**
 * Created by Varvara on 4/25/2017.
 */
public interface RoomDAO extends AbstractDAO<Room, Integer> {
    List<Room> getByHotelID(int hotelID);
    List<Room> getFreeRoomsInHotelByDate (int hotelID, Date start, Date end);
    List<Room> getFreeRoomsInHotelByDate (SearchFilter searchFilter, int hotelID);

    boolean isRoomFree(int roomId, int orderId, SearchFilter searchFilter);
}
