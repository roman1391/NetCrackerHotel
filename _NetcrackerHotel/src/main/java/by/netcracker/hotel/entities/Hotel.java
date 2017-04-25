package by.netcracker.hotel.entities;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Varvara on 4/1/2017.
 */
public class Hotel {

    private int id;
    private String country;
    private String city;
    private String address;
    private String name;
    private int typeOfService;
    private String description;
    private String photoURL;

    public Hotel() {
    }

    public static List<Room> getRooms(){
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1, 1, 1, 1));
        rooms.add(new Room(2, 2, 2, 2));
        rooms.add(new Room(3, 3, 3, 3));
        rooms.add(new Room(4, 4, 4, 4));
        return rooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(int typeOfService) {
        this.typeOfService = typeOfService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    @Override
    public String toString() {
        return "Hotel [country=" + country + ", city=" + city + ", address=" + address + ", name=" + name
            + ", typeOfService=" + typeOfService + ", description=" + description + ", id=" + id + ", photoURL="
            + photoURL + "]";
    }

}
