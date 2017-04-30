package by.netcracker.hotel.dao.impl.pagination;

import java.util.ArrayList;
import java.util.List;
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
    List<Object> paramsToQuery = new ArrayList<>();

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public HotelPaginationDAO(DataSource dataSource) {
        super(dataSource);
        setRowAmount(8);
        setRowMapper(new HotelMapper());
        setTypeId(TypeName.HOTEL.getType());
        setTypeName("hotel");
    }

    @Override
    public void setMapFilters(Map<String, String> mapFilters, HotelSearchParam pparam) {
        mapFilters.put("typeOfService", pparam.getTypeOfService());
        mapFilters.put("name", pparam.getName());

    }

}
