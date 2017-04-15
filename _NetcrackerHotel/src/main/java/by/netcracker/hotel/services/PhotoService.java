package by.netcracker.hotel.services;

import by.netcracker.hotel.entities.Photo;

import java.io.File;

/**
 * Created by Varvara on 4/15/2017.
 */
public interface PhotoService {
    public void addPhoto(Photo photo, File file);
}
