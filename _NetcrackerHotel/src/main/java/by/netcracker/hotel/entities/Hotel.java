package by.netcracker.hotel.entities;


import by.netcracker.hotel.cloud.CloudinaryConnector;

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
    private String mainPhoto;
    private List<String> photos;

    public Hotel() {
        photos = new ArrayList<>();
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
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

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = CloudinaryConnector.getCloudinary().url().format("jpg").generate(mainPhoto);
    }

    @Override
    public String toString() {
        return "Hotel [country=" + country + ", city=" + city + ", address=" + address + ", name=" + name
            + ", typeOfService=" + typeOfService + ", description=" + description + ", id=" + id + ", mainPhoto="
            + mainPhoto + "]";
    }

    public void addPhoto(String photo) {
        photos.add(CloudinaryConnector.getCloudinary().url().format("jpg").generate(photo));
    }
}
