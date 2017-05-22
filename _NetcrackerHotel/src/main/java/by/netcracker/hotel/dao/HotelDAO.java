package by.netcracker.hotel.dao;

import java.util.List;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.utils.SearchFilter;

/**
 * Created by Varvara on 4/4/2017.
 */
public interface HotelDAO extends AbstractDAO<Hotel, Integer> {
    List<Integer> findIDsBySearchString(String searchString);

    List<String> getPlaces();

    void addPhoto(String photo, int hotelID);

    List<String> getHotelNames();

    Hotel getByName(String name);

    //List<Hotel> findHotelsBySearchStrings(List<String> searchStrings);

    List<Hotel> findHotelsBySearchStrings(List<String> searchStrings, SearchFilter searchFilter);

    void deletePhoto(String photo);
}
