package by.netcracker.hotel.services.impl;

import by.netcracker.hotel.dao.PhotoDAO;
import by.netcracker.hotel.entities.Photo;
import by.netcracker.hotel.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

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
    public void addPhoto(Photo photo) {
        photoDAO.add(photo);
    }
}
