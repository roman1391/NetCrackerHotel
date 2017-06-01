package by.netcracker.hotel.dao.pagination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.github.paginationspring.bo.BoPaginationParam;

import by.netcracker.hotel.enums.SqlQuery;

public abstract class AbstractPaginationJdbcDAO<E, P extends BoPaginationParam> extends JdbcDaoSupport
    implements com.github.paginationspring.dao.PaginationDao<E, P> {

    private DataSource dataSource;
    private boolean isSorted = false;
    private RowMapper<E> rowMapper;
    private int pageNum;
    protected List<Object> paramsToQuery = new ArrayList<>();
    protected Map<String, String> mapFilters = new HashMap<>();
    protected Map<String, String> boToDbMap = new HashMap<>();
    protected int typeId;
    protected String typeName;

    public AbstractPaginationJdbcDAO(DataSource dataSource) {
        this.dataSource = dataSource;
        setPageNum(10);
    }

    @Override
    public int retrieveCountResult(P pparam) throws Exception {
        int countResult = getJdbcTemplate().queryForObject(buildCountQuery(pparam), paramsToQuery.toArray(),
            Integer.class);
        return countResult;
    }

    @Override
    public List<E> retrievePageResult(P pparam) throws Exception {
        String query = buildPageQuery(pparam);
        List<E> pageResult = getJdbcTemplate().query(query, paramsToQuery.toArray(),
            new RowMapperResultSetExtractor<E>(rowMapper) {
            });
        return pageResult;
    }

    public String buildPageQuery(P pparam) {
        StringBuffer query = new StringBuffer();
        query.append(SqlQuery.MAKE_PAGE.getQuery()).append(buildFullQuery(pparam)).append(" ) nn ) aaa limit ")
            .append(pparam.getResultIndex()).append(" ,").append(pageNum)
            .append(" ) yyy on ooo.entity_id = yyy.entity_id order by num ");
        return query.toString();
    }

    public String buildCountQuery(P pparam) {
        StringBuffer query = new StringBuffer();
        query.append("select count(distinct entity_id) from (");
        query.append(buildFullQuery(pparam)).append(" ) ccc");
        return query.toString();
    }

    public String buildFullQuery(P pparam) {
        StringBuffer query = new StringBuffer();
        paramsToQuery.clear();
        setBoToDbMap(boToDbMap, pparam);
        setMapFilters(mapFilters, pparam);
        // simple query without sorting
        if (pparam.getSortName() == null) {
            query.append(SqlQuery.ALL_PAGINATION.getQuery()); // 1:type_id
            query.append(!hasAnyFilter(mapFilters) ? " order by entity_id " : "");
            paramsToQuery.add(typeId);
        } else { // if sorting exist
            paramsToQuery.add(typeName);
            paramsToQuery.add(boToDbMap.get(pparam.getSortName().toLowerCase()));
            query.append(SqlQuery.SORTED_PAGINATION.getQuery()); // 2:'user','username'
            query.append(pparam.getOrderDirections().equals("asc") ? " desc " : " asc ");
            query.append(" ) aaa) bbb on v.entity_id = bbb.entity_id order by bbb.num ) ooo  ");
            isSorted = true;
        }
        // filters
        if (hasAnyFilter(mapFilters)) {
            addFiltersToQuery(query);
        }
        isSorted = false;
        return query.toString();
    }

    private void addFiltersToQuery(StringBuffer query) {
        if (isSorted) {
            query.append(" ").append(SqlQuery.AFTER_SORTED_PART.getQuery());
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
        query.append(isSorted ? " order by num" : " order by entity_id");
    }

    private boolean hasAnyFilter(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().equals("")) {
                return true;
            }
        }
        return false;
    }

    public RowMapper<E> getRowMapper() {
        return rowMapper;
    }

    public void setRowMapper(RowMapper<E> rowMapper) {
        this.rowMapper = rowMapper;
    }

    public Map<String, String> getMapFilters() {
        return mapFilters;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Map<String, String> getBoToDbMap() {
        return boToDbMap;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    // sets filters according to pparam variable
    public abstract void setMapFilters(Map<String, String> mapFilters, P pparam);

    // matches pparam possible sorting options to prepared statement parameter
    public abstract void setBoToDbMap(Map<String, String> boToDbMap, P pparam);

}
