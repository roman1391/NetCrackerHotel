package by.netcracker.hotel.dao.pagination;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.dao.constants.TypeName;
import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.entities.pagination.ReviewSearchParam;
import by.netcracker.hotel.mappers.ReviewMapper;

@Repository
public class ReviewPaginationDAO extends AbstractPaginationJdbcDAO<Review, ReviewSearchParam> {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private HotelDAO hotelDAO;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public ReviewPaginationDAO(DataSource dataSource) {
        super(dataSource);
        setRowMapper(new ReviewMapper());
        setTypeId(TypeName.REVIEW.getType());
        setTypeName("review");
    }

    @Override
    public void setMapFilters(Map<String, String> mapFilters, ReviewSearchParam pparam) {
        mapFilters.put("status", pparam.getStatus());
        mapFilters.put("rev_username", pparam.getUsername());
        mapFilters.put("rev_hotel", pparam.getHotelname());
    }

    @Override
    public void setBoToDbMap(Map<String, String> boToDbMap, ReviewSearchParam pparam) {
        boToDbMap.put("status", "status");
        boToDbMap.put("username", "rev_username");
        boToDbMap.put("hotelname", "rev_hotel");
        boToDbMap.put("time", "time");
    }

}
