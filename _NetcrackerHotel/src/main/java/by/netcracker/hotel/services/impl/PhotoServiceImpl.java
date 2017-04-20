package by.netcracker.hotel.services.impl;

import by.netcracker.hotel.cloud.CloudinaryConnector;
import by.netcracker.hotel.dao.PhotoDAO;
import by.netcracker.hotel.entities.Photo;
import by.netcracker.hotel.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Varvara on 4/15/2017.
 */
@Service("PhotoServiceImpl")
public class PhotoServiceImpl implements PhotoService {
    private final PhotoDAO photoDAO;

    @Autowired
    public PhotoServiceImpl(PhotoDAO photoDAO) {
        this.photoDAO = photoDAO;
    }


    @Override
    public void addPhoto(Photo photo) {
        photoDAO.add(photo);
    }

    @Override
    public List<Photo> getPhotosForHotel(int id) {
        return photoDAO.getPhotosForHotel(id);
    }

    @Override
    public void addPhotosToHotel(List<Photo> photos) {
        for(Photo photo: photos){
            addPhoto(photo);
        }
    }

}
