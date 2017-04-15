package by.netcracker.hotel.util;

import by.netcracker.hotel.entities.Hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Varvara on 4/1/2017.
 */
public class SampleDataGenerator {
    /*public static List<Hotel> createHotelList() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel("France", "Paris", "Abracadabra", "Paris Hotel", 5,
                "paris.jpg"));
        hotels.add(new Hotel("Italy", "Rome", "Here must be address", "Rome Hotel", 3,
                "rome.jpg"));
        return hotels;
    }*/

    public static List<String> createPlaces() {
        List<String> places = new ArrayList<>();
        places.add("Italy");
        places.add("Rome");
        places.add("France");
        places.add("Paris");
        places.add("Paris Hotel");
        places.add("Rome Hotel");
        return places;
    }
}
