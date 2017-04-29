package by.netcracker.hotel.services.impl;

import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.services.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Varvara on 4/8/2017.
 */

@Service("HotelServiceImpl")
public class HotelServiceImpl implements HotelService {
    private final HotelDAO hotelDAO;

    @Override
    public Hotel getByID(Integer id) {
        Hotel hotel = hotelDAO.getByID(id);
        return hotel;
    }

    @Autowired
    public HotelServiceImpl(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    @Override
    public List<Hotel> findHotels(List<String> searchStrings) {
        List<Hotel> hotels = new ArrayList<>();
        if (!searchStrings.isEmpty()) {
            List<Integer> ids = new ArrayList<>();
            ids.addAll(hotelDAO.findIDsBySearchString(searchStrings.remove(0)));
            for (String searchString : searchStrings) {
                ids.retainAll(hotelDAO.findIDsBySearchString(searchString));
            }
            for (Integer id : ids) {
                hotels.add(hotelDAO.getByID(id));
            }
        }
        return hotels;
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


}
