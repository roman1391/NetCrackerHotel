package by.netcracker.hotel.services.impl;

import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.dao.RoomDAO;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.services.HotelService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Varvara on 4/8/2017.
 */

@Service("HotelServiceImpl")
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
    public Map<Hotel, List<Room>> findHotels(List<String> searchStrings, String start, String end) {
        /*List<Hotel> hotels = new ArrayList<>();
        if (!searchStrings.isEmpty()) {
            List<Integer> ids = new ArrayList<>();
            ids.addAll(hotelDAO.findIDsBySearchString(searchStrings.remove(0)));
            for (String searchString : searchStrings) {
                ids.retainAll(hotelDAO.findIDsBySearchString(searchString));
            }
            for (Integer id : ids) {
                hotels.add(hotelDAO.getByID(id));
            }
        }*/
        List<Hotel> hotels = hotelDAO.findHotelsBySearchStrings(searchStrings);
        Map<Hotel, List<Room>> hotelsWithRooms = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        if (!StringUtils.isBlank(start) && !StringUtils.isBlank(end)) {
            for (Hotel hotel : hotels) {
                try {
                    hotelsWithRooms.put(hotel, roomDAO.getFreeRoomsInHotelByDate(hotel.getId(), dateFormat.parse(start),
                            dateFormat.parse(end)));
                } catch (ParseException e) {
                    return null;
                }
            }
        } else {
            for (Hotel hotel : hotels) {
                hotelsWithRooms.put(hotel, roomDAO.getByHotelID(hotel.getId()));
            }
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
    public void addHotel(Hotel hotel) {
        hotelDAO.add(hotel);
    }

    @Override
    public List<String> getHotelNames() {
        return hotelDAO.getHotelNames();
    }

    @Override
    public void addPhoto(String photo, int hotelID) {
        hotelDAO.addPhoto(photo, hotelID);
    }


}
