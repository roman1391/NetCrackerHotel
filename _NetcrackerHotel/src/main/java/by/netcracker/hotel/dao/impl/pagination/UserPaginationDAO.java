package by.netcracker.hotel.dao.impl.pagination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.pagination.UserSearchParam;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mapper.UserMapper;

@Repository
public class UserPaginationDAO extends JdbcDaoSupport
    implements com.github.paginationspring.dao.PaginationDao<User, UserSearchParam> {
    private DataSource dataSource;
    List<Object> paramsToQuery = new ArrayList<>();
    private boolean isSorted = false;
    // UserDAO userDAO;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Autowired
    public UserPaginationDAO(DataSource dataSource, UserDAO userDAO) {
        this.dataSource = dataSource;
        // this.userDAO = userDAO;
    }

    @Override
    public int retrieveCountResult(UserSearchParam pparam) throws Exception {
        int rows = getJdbcTemplate().queryForObject(buildCountQuery(pparam), paramsToQuery.toArray(), Integer.class);
        int countResult = rows / 8;
        return countResult;
    }

    @Override
    public List<User> retrievePageResult(UserSearchParam pparam) throws Exception {
        List<User> pageResult = getJdbcTemplate().query(buildPageQuery(pparam), paramsToQuery.toArray(),
            new RowMapperResultSetExtractor<User>(new UserMapper()) {
            });
        return pageResult;
    }

    public List<User> getUsers(UserSearchParam pparam) {
        return getJdbcTemplate().query(buildFullQuery(pparam), paramsToQuery.toArray(),
            new RowMapperResultSetExtractor<User>(new UserMapper()) {
            });
    }

    public String buildPageQuery(UserSearchParam pparam) {
        StringBuffer query = new StringBuffer();
        int rows = Integer.parseInt(pparam.getResultIndex()) * 8;
        query.append(buildFullQuery(pparam)).append(" limit " + rows + " , 80");
        return query.toString();
    }

    public String buildCountQuery(UserSearchParam pparam) {
        StringBuffer query = new StringBuffer();
        query.append("select count(*) from (");
        query.append(buildFullQuery(pparam)).append(" ) ccc");
        return query.toString();
    }

    public String buildFullQuery(UserSearchParam pparam) {
        StringBuffer query = new StringBuffer();
        Map<String, String> mapFilters = new HashMap<>();
        mapFilters.put("authority", pparam.getAuthority());
        mapFilters.put("enabled", pparam.getEnabled());
        mapFilters.put("username", pparam.getUsername());
        paramsToQuery.clear();
        // простой запрос
        if (pparam.getSortName() == null) {
            query.append(SqlQuery.ALL_PAGINATION.getQuery()); // 1:type_id
            paramsToQuery.add(TypeName.USER.getType());
        } else { // если есть сортировка
            paramsToQuery.add("user");
            paramsToQuery.add(pparam.getSortName());
            query.append(SqlQuery.SORTED_PAGINATION.getQuery()); // 2:'user','username'
            isSorted = true;
        }
        // фильтры
        if (hasAnyFilter(mapFilters)) {
            if (isSorted) {
                query.append(" " + SqlQuery.AFTER_SORTED_PART.getQuery());
            } else {
                query.append(SqlQuery.AFTER_ALL_PART.getQuery());
            }
            int cycle = 0; // counts number of cycles
            for (Map.Entry<String, String> entry : mapFilters.entrySet()) {
                if (entry.getValue() != null && !entry.getValue().equals("")) {
                    ++cycle;
                    paramsToQuery.add(entry.getKey());
                    paramsToQuery.add(entry.getValue());
                    query.append(cycle == 2 ? " where entity_id in " : "");
                    query.append(cycle == 3 ? " and entity_id in " : "");
                    query.append(SqlQuery.ADD_FILTER.getQuery()); // +2:атрибут+значение;
                    query.append(cycle == 1 ? " xxx " : "");
                }
            }
            query.append(" ) ");
            query.append(isSorted ? " order by num" : "");
        }
        isSorted = false;
        return query.toString();
    }

    private boolean hasAnyFilter(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().equals("")) {
                return true;
            }
        }
        return false;
    }

}
