package by.netcracker.hotel.dao.pagination;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.entities.pagination.ReviewSearchParam;
import by.netcracker.hotel.mapper.ReviewMapper;

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
        setRowAmount(7);
        setRowMapper(new ReviewMapper());
        setTypeId(TypeName.REVIEW.getType());
        setTypeName("review");
    }

    @Override
    public void setMapFilters(Map<String, String> mapFilters, ReviewSearchParam pparam) {
        mapFilters.put("hotelid",
            pparam.getHotelname() == null ? "" : String.valueOf((hotelDAO.getByName(pparam.getHotelname()).getId())));
        mapFilters.put("status", pparam.getStatus());
        mapFilters.put("rev_username", pparam.getUsername());
    }

    @Override
    public void setBoToDbMap(Map<String, String> boToDbMap, ReviewSearchParam pparam) {
        boToDbMap.put("username", "rev_username");
        boToDbMap.put("hotelname", "authority");
        boToDbMap.put("status", "status");
        boToDbMap.put("time", "time");
    }

}
