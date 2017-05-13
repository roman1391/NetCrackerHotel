package by.netcracker.hotel.dao.pagination;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;

import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.pagination.UserSearchParam;

@Repository
public class UserPaginationDAO extends AbstractPaginationJdbcDAO<User, UserSearchParam> {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private WebApplicationContext context;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public UserPaginationDAO(WebApplicationContext context, DataSource dataSource) {
        super(dataSource);
        setRowMapper((RowMapper<User>) context.getBean("userMapper"));
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
        boToDbMap.put("email", "email");
    }

}
