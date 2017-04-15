package by.netcracker.hotel.entities;

/**
 * Created by Varvara on 4/15/2017.
 */
public class Photo {
    private int idHotel;
    private String photoName;

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Photo(int idHotel, String photoName) {
        this.idHotel = idHotel;
        this.photoName = photoName;
    }

    public Photo() {
    }
}
