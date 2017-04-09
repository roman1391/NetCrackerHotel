package by.netcracker.hotel.services;

import by.netcracker.hotel.entities.Hotel;

import java.util.List;

/**
 * Created by Varvara on 4/8/2017.
 */
public interface HotelService extends AbstractService <Hotel, Integer> {
    public List<Hotel> findHotels(List<String> searchStrings);
}
