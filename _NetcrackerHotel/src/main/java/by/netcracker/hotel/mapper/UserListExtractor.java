package by.netcracker.hotel.mapper;

import by.netcracker.hotel.entities.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by slava on 10.04.17.
 */
public class UserListExtractor implements ResultSetExtractor {
    private final RowMapper rowMapper;
    private final int rowsExpected;

    public UserListExtractor(RowMapper rowMapper){
        this.rowMapper = rowMapper;
        this.rowsExpected = 0;
    }

    public UserListExtractor(RowMapper rowMapper, int rowExpected){
        this.rowMapper = rowMapper;
        this.rowsExpected = rowExpected;
    }

    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List results = (this.rowsExpected > 0 ? new ArrayList(this.rowsExpected) : new ArrayList());
        int rowNum = 0;
        while (resultSet.next()) {
            User user = (User) this.rowMapper.mapRow(resultSet, rowNum);
            if(user!=null) {
                results.add(user);
            }
        }
        return results;
    }
}
