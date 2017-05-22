package by.netcracker.hotel.services;

import java.util.List;
import java.util.Map;

import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.Room;
import by.netcracker.hotel.utils.SearchFilter;

/**
 * Created by Varvara on 4/8/2017.
 */
public interface HotelService extends AbstractService<Hotel, Integer> {
    //Map<Hotel, List<Room>> findHotels(List<String> searchStrings, String start, String end);

    Map<Hotel, List<Room>> findHotels(List<String> searchStrings, SearchFilter searchFilter);

    List<Hotel> getAll();

    List<String> getPlaces();

    void addHotel(Hotel hotel);

    List<String> getHotelNames();

    void addPhoto(String photo, int hotelID);

    void editHotel(Hotel hotel);

    void deletePhoto(String[] photo);
}
