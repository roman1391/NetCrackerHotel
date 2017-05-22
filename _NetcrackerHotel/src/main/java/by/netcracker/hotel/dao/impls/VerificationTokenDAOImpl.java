package by.netcracker.hotel.dao.impls;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.VerificationTokenDAO;
import by.netcracker.hotel.dao.constants.ColumnName;
import by.netcracker.hotel.dao.constants.TypeName;
import by.netcracker.hotel.entities.VerificationToken;
import by.netcracker.hotel.enums.SqlQuery;
import by.netcracker.hotel.mappers.VerificationTokenMapper;

/**
 * Created by slava on 15.04.17.
 */
@Repository
@Singleton
public class VerificationTokenDAOImpl extends JdbcDaoSupport implements VerificationTokenDAO {

    private static Logger log = Logger.getLogger(VerificationTokenDAOImpl.class);
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Autowired
    public VerificationTokenDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(VerificationToken token) {
        getJdbcTemplate().update(SqlQuery.ADD_ENTITY_ID.getQuery(), TypeName.VERIFICATION_TOKEN.name().toLowerCase());
        getJdbcTemplate().update(SqlQuery.ADD_TOKEN.getQuery(), token.getUserID(), token.getToken(),
            new Timestamp(token.getDate().getTime()));
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
            return getJdbcTemplate().queryForObject(SqlQuery.GET_BY_ID.getQuery(), new Object[] { id },
                new VerificationTokenMapper());
        } catch (EmptyResultDataAccessException e) {
            log.warn("Exception in verificationTokenDAO while getting by id", e);
            return null;
        }
    }

    @Override
    public List<VerificationToken> getAll() {
        return getJdbcTemplate().query(SqlQuery.GET_ALL.getQuery(),
            new Object[] { TypeName.VERIFICATION_TOKEN.getType() },
            new RowMapperResultSetExtractor<VerificationToken>(new VerificationTokenMapper()) {
            });
    }

    @Override
    public VerificationToken getByToken(String token) {
        try {
            VerificationToken verificationToken = (VerificationToken) getJdbcTemplate().queryForObject(
                SqlQuery.GET_BY.getQuery(), new Object[] { ColumnName.VERIFICATION_TOKEN_TOKEN, token },
                new VerificationTokenMapper());
            return verificationToken;
        } catch (EmptyResultDataAccessException e) {
            log.warn("EmptyResultDataAccessException in verificationTokenDAO while getting by token", e);
            return null;
        }
    }

    @Override
    public VerificationToken getByUserID(int userID) {
        try {
            VerificationToken verificationToken = (VerificationToken) getJdbcTemplate().queryForObject(
                SqlQuery.GET_BY.getQuery(), new Object[] { ColumnName.VERIFICATION_TOKEN_USER_ID, userID },
                new VerificationTokenMapper());
            return verificationToken;
        } catch (EmptyResultDataAccessException e) {
            log.warn("EmptyResultDataAccessException in verificationTokenDAO while getting by user id", e);
            return null;
        }
    }
}
