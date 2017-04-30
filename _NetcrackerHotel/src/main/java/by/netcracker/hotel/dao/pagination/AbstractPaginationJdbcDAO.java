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
    protected List<Object> paramsToQuery = new ArrayList<>();
    protected Map<String, String> mapFilters = new HashMap<>();
    protected Map<String, String> boToDbMap = new HashMap<>();
    protected int rowAmount;
    protected int typeId;
    protected String typeName;

    public AbstractPaginationJdbcDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int retrieveCountResult(P pparam) throws Exception {
        int rows = getJdbcTemplate().queryForObject(buildCountQuery(pparam), paramsToQuery.toArray(), Integer.class);
        int countResult = rows / getRowAmount();
        return countResult;
    }

    @Override
    public List<E> retrievePageResult(P pparam) throws Exception {
        List<E> pageResult = getJdbcTemplate().query(buildPageQuery(pparam), paramsToQuery.toArray(),
            new RowMapperResultSetExtractor<E>(rowMapper) {
            });
        return pageResult;
    }

    public String buildPageQuery(P pparam) {
        StringBuffer query = new StringBuffer();
        int rows = Integer.parseInt(pparam.getResultIndex()) * getRowAmount();
        query.append(buildFullQuery(pparam, mapFilters)).append(" limit " + rows + " , 80");
        return query.toString();
    }

    public String buildCountQuery(P pparam) {
        StringBuffer query = new StringBuffer();
        query.append("select count(*) from (");
        query.append(buildFullQuery(pparam, mapFilters)).append(" ) ccc");
        return query.toString();
    }

    public String buildFullQuery(P pparam, Map<String, String> map) {
        StringBuffer query = new StringBuffer();
        paramsToQuery.clear();
        setBoToDbMap(boToDbMap, pparam);
        setMapFilters(mapFilters, pparam);
        // простой запрос
        if (pparam.getSortName() == null) {
            query.append(SqlQuery.ALL_PAGINATION.getQuery()); // 1:type_id
            query.append(!hasAnyFilter(mapFilters) ? " order by entity_id " : "");
            paramsToQuery.add(typeId);
        } else { // если есть сортировка
            paramsToQuery.add(typeName);
            paramsToQuery.add(boToDbMap.get(pparam.getSortName().toLowerCase()));
            query.append(SqlQuery.SORTED_PAGINATION.getQuery()); // 2:'user','username'
            query.append(pparam.getOrderDirections().equals("asc") ? " desc " : " asc ");
            query.append(" ) aaa) bbb on v.entity_id = bbb.entity_id order by bbb.num ) ooo ");
            isSorted = true;
        }
        // фильтры
        if (hasAnyFilter(mapFilters)) {
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

    public RowMapper<E> getRowMapper() {
        return rowMapper;
    }

    public void setRowMapper(RowMapper<E> rowMapper) {
        this.rowMapper = rowMapper;
    }

    public Map<String, String> getMapFilters() {
        return mapFilters;
    }

    public abstract void setMapFilters(Map<String, String> mapFilters, P pparam);

    public int getRowAmount() {
        return rowAmount;
    }

    public void setRowAmount(int rowAmount) {
        this.rowAmount = rowAmount;
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

    public abstract void setBoToDbMap(Map<String, String> boToDbMap, P pparam);

}
