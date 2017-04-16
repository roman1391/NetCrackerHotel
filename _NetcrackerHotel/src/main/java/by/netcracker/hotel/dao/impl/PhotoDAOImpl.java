package by.netcracker.hotel.dao.impl;

import by.netcracker.hotel.dao.PhotoDAO;
import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.Photo;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mapper.HotelMapper;
import by.netcracker.hotel.mapper.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Varvara on 4/15/2017.
 */
@Repository
public class PhotoDAOImpl extends JdbcDaoSupport implements PhotoDAO {

    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Autowired
    public PhotoDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Photo photo) {/*
        getJdbcTemplate().update(SqlQuery.ADD_ENTITY_ID.getQuery(), TypeName.PHOTOS.name().toLowerCase());
        getJdbcTemplate().update(SqlQuery.ADD_PHOTO.getQuery(), photo.getIdHotel(), photo.getPhotoName());
        */
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SqlQuery.ADD_ENTITY_ID.getQuery(),
                        new String[]{"id"});
                ps.setString(1, TypeName.PHOTOS.name().toLowerCase());
                return ps;
            }
        }, keyHolder);

        photo.setPhotoName(String.valueOf(keyHolder.getKey().intValue()));
        getJdbcTemplate().update(SqlQuery.ADD_PHOTO.getQuery(), photo.getIdHotel(), photo.getPhotoName());
    }

    @Override
    public void deleteByID(Integer integer) {

    }

    @Override
    public void update(Photo entity) {

    }

    @Override
    public Photo getByID(Integer integer) {
        return null;
    }

    @Override
    public List<Photo> getAll() {
        return null;
    }

    @Override
    public List<Photo> getPhotosForHotel(int id) {
        return getJdbcTemplate().query(SqlQuery.GET_PHOTOS_FOR_HOTEL.getQuery(), new Object[]
                {id}, new RowMapperResultSetExtractor<Photo>(new PhotoMapper()) {
        });
    }

}
