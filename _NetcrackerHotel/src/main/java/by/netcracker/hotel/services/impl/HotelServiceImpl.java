package by.netcracker.hotel.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.dao.RoomDAO;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.services.HotelService;
import by.netcracker.hotel.utils.SearchFilter;

/**
 * Created by Varvara on 4/8/2017.
 */

@Service("hotelServiceImpl")
@SessionScope
public class HotelServiceImpl implements HotelService {
    private final HotelDAO hotelDAO;
    private final RoomDAO roomDAO;

    @Override
    public Hotel getByID(Integer id) {
        Hotel hotel = hotelDAO.getByID(id);
        return hotel;
    }

    @Autowired
    public HotelServiceImpl(HotelDAO hotelDAO, RoomDAO roomDAO) {
        this.hotelDAO = hotelDAO;
        this.roomDAO = roomDAO;
    }

    @Override
    public Map<Hotel, List<Room>> findHotels(List<String> searchStrings, SearchFilter searchFilter) {
        List<Hotel> hotels = hotelDAO.findHotelsBySearchStrings(searchStrings, searchFilter);
        Map<Hotel, List<Room>> hotelsWithRooms = new HashMap<>();
        for (Hotel hotel : hotels) {
            hotelsWithRooms.put(hotel, roomDAO.getFreeRoomsInHotelByDate(searchFilter, hotel.getId()));
        }
        return hotelsWithRooms;
    }

    @Override
    public List<Hotel> getAll() {
        return hotelDAO.getAll();
    }

    @Override
    public List<String> getPlaces() {
        return hotelDAO.getPlaces();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void addHotel(Hotel hotel) {
        hotel.setEnabled(true);
        hotelDAO.add(hotel);
    }

    @Override
    public List<String> getHotelNames() {
        return hotelDAO.getHotelNames();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void addPhoto(String photo, int hotelID) {
        hotelDAO.addPhoto(photo, hotelID);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void editHotel(Hotel hotel) {
        hotelDAO.update(hotel);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deletePhoto(String[] photo) {
        for (int i = 1; i < photo.length; i++) {
            int n = photo[i].split("/").length - 1;
            String photoName = photo[i].split("/")[n];
            hotelDAO.deletePhoto(photoName.substring(0, photoName.length() - 4));
        }
    }

}
