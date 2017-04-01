package by.netcracker.hotel.entities;

/**
 * Created by Varvara on 4/1/2017.
 */
public class Hotel {
    private String country;
    private String city;
    private String address;
    private String name;
    private int typeOfService;
    private String imagePath;

    public Hotel(){}

    public Hotel(String country, String city, String address, String name, int typeOfService, String imagePath){
        this.country = country;
        this.city = city;
        this.address = address;
        this.name = name;
        this.typeOfService = typeOfService;
        this.imagePath = imagePath;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}