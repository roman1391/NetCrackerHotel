package by.netcracker.hotel.services.impl;

import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Varvara on 4/8/2017.
 */

@Service("HotelServiceImpl")
public class HotelServiceImpl implements HotelService {
    private final WebApplicationContext context;
    private final HotelDAO hotelDAO;

    @Override
    public Hotel getByID(Integer id) {
        return hotelDAO.getByID(id);
    }

    @Autowired
    public HotelServiceImpl(WebApplicationContext context, HotelDAO hotelDAO) {
        this.context = context;
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
    public List<String> getPlaces() {
        return hotelDAO.getPlaces();
    }
}
