package by.netcracker.hotel.dao;

import by.netcracker.hotel.entities.Hotel;

import java.util.List;

/**
 * Created by Varvara on 4/4/2017.
 */
public interface HotelDAO extends AbstractDAO<Hotel, Integer>{
    List<Integer> findIDsBySearchString(String searchString);
}
