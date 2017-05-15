package by.netcracker.hotel.services.impl;

import by.netcracker.hotel.dao.RoomDAO;
import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.filter.SearchFilter;
import by.netcracker.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Varvara on 4/25/2017.
 */

@Service("RoomServiceImpl")
@SessionScope
public class RoomServiceImpl implements RoomService{
    private final RoomDAO roomDAO;

    @Autowired
    public RoomServiceImpl(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Override
    public Room getByID(Integer id) {
        return roomDAO.getByID(id);
    }

    @Override
    public void add(Room room) {
        roomDAO.add(room);
    }

    @Override
    public List<Room> getByHotelID(int hotelID) {
        return roomDAO.getByHotelID(hotelID);
    }

    @Override
    public List<Room> getFreeRoomsInHotelByDate(int hotelID, SearchFilter searchFilter/*String start, String end*/) {
        List<Room> freeRooms = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            //freeRooms = roomDAO.getFreeRoomsInHotelByDate(hotelID, dateFormat.parse(start), dateFormat.parse(end));
            freeRooms = roomDAO.getFreeRoomsInHotelByDate(searchFilter, hotelID );

        return freeRooms;
    }

    @Override
    public boolean isRoomFree(int roomId, SearchFilter searchFilter) {
        return roomDAO.isRoomFree(roomId, searchFilter);
    }


}
