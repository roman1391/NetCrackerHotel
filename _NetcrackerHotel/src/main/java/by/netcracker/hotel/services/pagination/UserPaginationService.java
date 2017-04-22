package by.netcracker.hotel.services.pagination;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.paginationspring.bo.BoPaginationColumn;
import com.github.paginationspring.service.PaginationServiceAbstract;

import by.netcracker.hotel.dao.impl.pagination.UserPaginationDAO;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.pagination.UserRow;
import by.netcracker.hotel.entities.pagination.UserSearchParam;

@Service
public class UserPaginationService extends PaginationServiceAbstract<UserSearchParam, UserRow, User> {

    private static Logger log = Logger.getLogger(UserPaginationService.class);

    private UserPaginationDAO userPaginationDAO;

    @Autowired
    public void setPaginationDao(UserPaginationDAO userPaginationDAO) {
        super.setPaginationDao(userPaginationDAO);
        this.userPaginationDAO = userPaginationDAO;
    }

    @Override
    public void assignColumnsDefinition(List<BoPaginationColumn> columns) throws Exception {
        log.debug("setting columns def.");

        BoPaginationColumn col = null;

        col = new BoPaginationColumn();
        col.setColumnName("Authority");
        // col.setOrderColumns("a.season, c.teamAlias, b.lastName,
        // b.firstName");
        // col.setOrderDirections("desc, asc, asc, asc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Enabled");
        // col.setOrderColumns("a.season, c.teamAlias, b.lastName,
        // b.firstName");
        // col.setOrderDirections("desc, asc, asc, asc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Username");
        // col.setOrderColumns("a.season, c.teamAlias, b.lastName,
        // b.firstName");
        // col.setOrderDirections("desc, asc, asc, asc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Email");
        // col.setOrderColumns("a.season, c.teamAlias, b.lastName,
        // b.firstName");
        // col.setOrderDirections("desc, asc, asc, asc");
        col.setWidth(30);
        columns.add(col);

    }

    @Override
    protected UserRow assignDataToBo(User user) throws Exception {
        UserRow bo = new UserRow();
        bo.setUserId(user.getId());
        bo.setAuthority(user.getAuthority().toString());
        bo.setEnabled(user.getEnabled() ? "Enabled" : "Unenabled");
        bo.setUsername(user.getUsername());
        bo.setEmail(user.getEmail());

        return bo;
    }

}
