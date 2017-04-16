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
    private String description;;
    private int id;
    private String photoURL;

    public Hotel(){
    }

    /*public Hotel(String country, String city, String address, String name, int typeOfService){
        this.country = country;
        this.city = city;
        this.address = address;
        this.name = name;
        this.typeOfService = typeOfService;
    }*/

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
}
