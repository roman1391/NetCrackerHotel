package by.netcracker.hotel.dao.pagination;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.pagination.HotelSearchParam;
import by.netcracker.hotel.mapper.HotelMapper;

@Repository
public class HotelPaginationDAO extends AbstractPaginationJdbcDAO<Hotel, HotelSearchParam> {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public HotelPaginationDAO(DataSource dataSource) {
        super(dataSource);
        setRowMapper(new HotelMapper());
        setTypeId(TypeName.HOTEL.getType());
        setTypeName("hotel");
    }

    @Override
    public void setMapFilters(Map<String, String> mapFilters, HotelSearchParam pparam) {
        mapFilters.put("class", pparam.getTypeOfService());
        mapFilters.put("hotel_name", pparam.getName());
        mapFilters.put("hotel_enabled", pparam.getEnabled());
    }

    @Override
    public void setBoToDbMap(Map<String, String> boToDbMap, HotelSearchParam pparam) {
        boToDbMap.put("class", "class");
        boToDbMap.put("city", "city");
        boToDbMap.put("name", "hotel_name");
        boToDbMap.put("enabled", "hotel_enabled");
        boToDbMap.put("country", "country");
    }

}
