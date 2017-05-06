package by.netcracker.hotel.services.impl;

import by.netcracker.hotel.dao.RoomDAO;
import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.services.AbstractService;
import by.netcracker.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

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
    public Room getByID(Integer integer) {
        return null;
    }

    @Override
    public void add(Room room) {
        roomDAO.add(room);
    }

    @Override
    public List<Room> getByHotelID(int hotelID) {
        return roomDAO.getByHotelID(hotelID);
    }
}
