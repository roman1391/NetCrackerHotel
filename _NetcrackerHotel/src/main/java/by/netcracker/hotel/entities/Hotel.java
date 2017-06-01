package by.netcracker.hotel.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cloudinary.Transformation;

import by.netcracker.hotel.utils.CloudinaryConnector;

/**
 * Created by Varvara on 4/1/2017.
 */
@Component
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
    private boolean enabled;

    public Hotel() {
        photos = new ArrayList<>();
    }

    public Hotel(String country, String city, String address, String name, int typeOfService, String description,
        boolean enabled, String mainPhoto) {
        super();
        this.country = country;
        this.city = city;
        this.address = address;
        this.name = name;
        this.typeOfService = typeOfService;
        this.description = description;
        this.enabled = enabled;
        this.mainPhoto = mainPhoto;
        photos = new ArrayList<>();
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
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

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = CloudinaryConnector.getCloudinary().url().format("jpg")
            .transformation(new Transformation().width(PHOTO_WIDTH).height(PHOTO_HEIGHT).crop("fill"))
            .generate(mainPhoto);
    }

    @Override
    public String toString() {
        return "Hotel [country=" + country + ", city=" + city + ", address=" + address + ", name=" + name
            + ", typeOfService=" + typeOfService + ", description=" + description + ", id=" + id + ", mainPhoto="
            + mainPhoto + "]";
    }

    public void addPhoto(String photo) {
        photos.add(CloudinaryConnector.getCloudinary().url().format("jpg")
            .transformation(new Transformation().width(PHOTO_WIDTH).height(PHOTO_HEIGHT).crop("fill")).generate(photo));
    }

    private static final int PHOTO_WIDTH = 600, PHOTO_HEIGHT = 300;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime * result + id;
        result = prime * result + ((mainPhoto == null) ? 0 : mainPhoto.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((photos == null) ? 0 : photos.hashCode());
        result = prime * result + typeOfService;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Hotel other = (Hotel) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (enabled != other.enabled)
            return false;
        if (id != other.id)
            return false;
        if (mainPhoto == null) {
            if (other.mainPhoto != null)
                return false;
        }
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (photos == null) {
            if (other.photos != null)
                return false;
        } else if (!photos.equals(other.photos))
            return false;
        if (typeOfService != other.typeOfService)
            return false;
        return true;
    }

}
