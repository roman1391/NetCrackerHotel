package by.netcracker.hotel.services;

import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.filter.SearchFilter;

import java.util.List;

/**
 * Created by Varvara on 4/25/2017.
 */
public interface RoomService extends AbstractService<Room, Integer>  {
    void add (Room room);
    List<Room> getByHotelID (int hotelID);
    List<Room> getFreeRoomsInHotelByDate(int hotelID, SearchFilter searchFilter/*String start, String end*/);
}
