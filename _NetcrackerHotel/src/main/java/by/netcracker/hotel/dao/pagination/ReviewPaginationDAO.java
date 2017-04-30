package by.netcracker.hotel.dao.pagination;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.entities.pagination.ReviewSearchParam;
import by.netcracker.hotel.mapper.ReviewMapper;

@Repository
public class ReviewPaginationDAO extends AbstractPaginationJdbcDAO<Review, ReviewSearchParam> {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public ReviewPaginationDAO(DataSource dataSource) {
        super(dataSource);
        setRowAmount(8);
        setRowMapper(new ReviewMapper());
        setTypeId(TypeName.USER.getType());
        setTypeName("user");
    }

    @Override
    public void setMapFilters(Map<String, String> mapFilters, ReviewSearchParam pparam) {
        mapFilters.put("authority", pparam.getHotelname());
        mapFilters.put("enabled", pparam.getStatus());
        mapFilters.put("username", pparam.getUsername());
    }

    @Override
    public void setBoToDbMap(Map<String, String> boToDbMap, ReviewSearchParam pparam) {
        boToDbMap.put("username", "username");
        boToDbMap.put("authority", "authority");
        boToDbMap.put("enabled", "enabled");
    }

}
