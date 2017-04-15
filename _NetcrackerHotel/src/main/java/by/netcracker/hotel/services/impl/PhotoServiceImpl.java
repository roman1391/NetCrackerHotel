package by.netcracker.hotel.services.impl;

import by.netcracker.hotel.cloud.CloudinaryConnector;
import by.netcracker.hotel.dao.PhotoDAO;
import by.netcracker.hotel.entities.Photo;
import by.netcracker.hotel.services.PhotoService;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Varvara on 4/15/2017.
 */
@Service("PhotoServiceImpl")
public class PhotoServiceImpl implements PhotoService {
    private final WebApplicationContext context;
    private final PhotoDAO photoDAO;

    @Autowired
    public PhotoServiceImpl(WebApplicationContext context, PhotoDAO hotelDAO, PhotoDAO photoDAO) {
        this.context = context;
        this.photoDAO = photoDAO;
    }


    @Override
    public void addPhoto(Photo photo, File file) {
        photoDAO.add(photo);
        try {
            Map uploadResult = CloudinaryConnector.getCloudinary().uploader().upload(file,
                    ObjectUtils.asMap("public_id", photo.getPhotoName(),
                            "transformation", new Transformation().crop("limit").width(400).height(400)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
