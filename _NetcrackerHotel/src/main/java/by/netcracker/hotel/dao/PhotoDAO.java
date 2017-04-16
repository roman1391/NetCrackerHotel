package by.netcracker.hotel.dao;

import by.netcracker.hotel.entities.Photo;

import java.util.List;

/**
 * Created by Varvara on 4/15/2017.
 */
public interface PhotoDAO extends AbstractDAO<Photo, Integer>{
    List<Photo> getPhotosForHotel(int id);
}
