package by.netcracker.hotel.mapper;

import by.netcracker.hotel.dao.constant.ColumnName;
import by.netcracker.hotel.entities.Photo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Varvara on 4/16/2017.
 */
public class PhotoMapper implements RowMapper<Photo> {
    @Override
    public Photo mapRow(ResultSet resultSet, int i) throws SQLException {
        Photo photo = new Photo();
        photo.setIdPhoto(resultSet.getInt(1));
        do {
            switch (resultSet.getString(2)) {
                case ColumnName.IDHOTEL: {
                    photo.setIdHotel(resultSet.getInt(3));
                    break;
                }
                case ColumnName.PHOTO: {
                    photo.setPhotoName(resultSet.getString(3));
                    break;
                }
            }
        } while (resultSet.next());
        return photo;
    }
}
