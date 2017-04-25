package by.netcracker.hotel.entities;

/**
 * Created by Varvara on 4/15/2017.
 */
public class Photo {
    private int idHotel;
    private String photoName;
    private int idPhoto;

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

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public Photo(int idHotel) {
        this.idHotel = idHotel;
        generateName();
    }

    public Photo() {
    }

    private void generateName(){
        StringBuilder randString = new StringBuilder();
        int count = (int)(Math.random()*27+3);
        for(int i=0;i<count;i++)
            randString.append((char)((int)(Math.random()*26+65)));
        setPhotoName(randString.toString());
    }
}
