package by.netcracker.hotel.dao.pagination;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.pagination.UserSearchParam;
import by.netcracker.hotel.mapper.UserMapper;

@Repository
public class UserPaginationDAO extends AbstractPaginationJdbcDAO<User, UserSearchParam> {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public UserPaginationDAO(DataSource dataSource) {
        super(dataSource);
        setRowAmount(8);
        setRowMapper(new UserMapper());
        setTypeId(TypeName.USER.getType());
        setTypeName("user");
    }

    @Override
    public void setMapFilters(Map<String, String> mapFilters, UserSearchParam pparam) {
        mapFilters.put("authority", pparam.getAuthority());
        mapFilters.put("enabled", pparam.getEnabled());
        mapFilters.put("username", pparam.getUsername());
    }

    @Override
    public void setBoToDbMap(Map<String, String> boToDbMap, UserSearchParam pparam) {
        boToDbMap.put("username", "username");
        boToDbMap.put("authority", "authority");
        boToDbMap.put("enabled", "enabled");
    }

}
