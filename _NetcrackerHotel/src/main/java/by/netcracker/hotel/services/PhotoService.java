package by.netcracker.hotel.services;

import by.netcracker.hotel.entities.Photo;

import java.io.File;
import java.util.List;

/**
 * Created by Varvara on 4/15/2017.
 */
public interface PhotoService {
    void addPhoto(Photo photo, File file);
    List<Photo> getPhotosForHotel(int id);
}
