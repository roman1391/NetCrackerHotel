package by.netcracker.hotel.dao.impl;

import by.netcracker.hotel.dao.VerificationTokenDAO;
import by.netcracker.hotel.dao.constant.ColumnName;
import by.netcracker.hotel.dao.constant.TypeName;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.VerificationToken;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mapper.VerificationTokenMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by slava on 15.04.17.
 */
@Component("VerificationTokenDAO")
public class VerificationTokenDAOImpl extends JdbcDaoSupport implements VerificationTokenDAO {
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void add(VerificationToken token) {
        getJdbcTemplate().update(SqlQuery.ADD_ENTITY_ID.getQuery(), TypeName.VERIFICATION_TOKEN.name().toLowerCase());
        getJdbcTemplate().update(SqlQuery.ADD_USER.getQuery(), token.getUserID(),token.getToken(),token.getDate());
    }

    @Override
    public void deleteByID(Integer id) {
        getJdbcTemplate().update(SqlQuery.DELETE_BY_ID.getQuery(), id);
    }

    @Override
    public void update(VerificationToken token) {

    }

    @Override
    public VerificationToken getByID(Integer id) {
        try {
            return getJdbcTemplate().queryForObject(SqlQuery.GET_BY_ID.getQuery(),
                    new Object[] { id },
                    new VerificationTokenMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<VerificationToken> getAll() {
        return getJdbcTemplate().query(SqlQuery.GET_ALL.getQuery(), new Object[] { TypeName.VERIFICATION_TOKEN.getType() },
                new RowMapperResultSetExtractor<VerificationToken>(new VerificationTokenMapper()) {
                });
    }

    @Override
    public VerificationToken getByToken(String token) {
        try {
            VerificationToken verificationToken = (VerificationToken) getJdbcTemplate().queryForObject(SqlQuery.GET_BY.getQuery(),
                    new Object[] { ColumnName.VERIFICATION_TOKEN_TOKEN, token }, new VerificationTokenMapper());
            return verificationToken;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public VerificationToken getByUserID(int userID) {
        try {
            VerificationToken verificationToken = (VerificationToken) getJdbcTemplate().queryForObject(SqlQuery.GET_BY.getQuery(),
                    new Object[] { ColumnName.VERIFICATION_TOKEN_USER_ID, userID }, new VerificationTokenMapper());
            return verificationToken;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
