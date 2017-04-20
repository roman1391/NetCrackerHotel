package by.netcracker.hotel.services;

import by.netcracker.hotel.entities.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * Created by Varvara on 4/15/2017.
 */
public interface PhotoService {
    void addPhoto(Photo photo);
    List<Photo> getPhotosForHotel(int id);
    void addPhotosToHotel(List<Photo> photos);
}
