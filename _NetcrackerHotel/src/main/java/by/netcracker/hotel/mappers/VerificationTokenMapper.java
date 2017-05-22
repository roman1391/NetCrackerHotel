package by.netcracker.hotel.mappers;

import by.netcracker.hotel.dao.constants.ColumnName;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.VerificationToken;
import by.netcracker.hotel.enums.ROLE;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by slava on 15.04.17.
 */
public class    VerificationTokenMapper implements RowMapper<VerificationToken> {
    @Override
    public VerificationToken mapRow(ResultSet resultSet, int i) throws SQLException {
        VerificationToken token = new VerificationToken();
        int currentID = resultSet.getInt(1);
        token.setId(currentID);
        do {
            if (currentID != resultSet.getInt(1)) {
                resultSet.previous();
                break;
            }
            switch (resultSet.getString(2)) {
                case ColumnName.VERIFICATION_TOKEN_USER_ID: {
                    token.setUserID(Integer.parseInt(resultSet.getString(3)));
                    break;
                }
                case ColumnName.VERIFICATION_TOKEN_TOKEN: {
                    token.setToken(resultSet.getString(3));
                    break;
                }
                case ColumnName.VERIFICATION_TOKEN_DATE: {
                    token.setDate(new Date(resultSet.getTimestamp(3).getTime()));
                }
            }
        } while (resultSet.next());
        return token;
    }
}
