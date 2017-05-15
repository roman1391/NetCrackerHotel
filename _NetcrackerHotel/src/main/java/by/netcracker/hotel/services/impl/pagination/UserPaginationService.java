package by.netcracker.hotel.services.impl.pagination;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.paginationspring.bo.BoPaginationColumn;
import com.github.paginationspring.dao.PaginationDao;
import com.github.paginationspring.service.PaginationServiceAbstract;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.dao.pagination.UserPaginationDAO;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.pagination.UserRow;
import by.netcracker.hotel.entities.pagination.UserSearchParam;

@Service
public class UserPaginationService extends PaginationServiceAbstract<UserSearchParam, UserRow, User> {

    private static Logger log = Logger.getLogger(UserPaginationService.class);

    private PaginationDao<User, UserSearchParam> userPaginationDAO;
    private UserDAO userDAO;

    @Autowired
    public void setPaginationDao(UserPaginationDAO userPaginationDAO, UserDAO userDAO) {
        super.setPaginationDao(userPaginationDAO);
        this.userPaginationDAO = userPaginationDAO;
        this.userDAO = userDAO;
    }

    @Override
    public void assignColumnsDefinition(List<BoPaginationColumn> columns) throws Exception {
        log.debug("setting columns def.");

        BoPaginationColumn col = null;

        col = new BoPaginationColumn();
        col.setColumnName("Username");
        col.setOrderColumns("username");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Authority");
        col.setOrderColumns("authority");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("State");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Email");
        col.setOrderColumns("email");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Profile");
        col.setWidth(30);
        columns.add(col);
    }

    @Override
    protected UserRow assignDataToBo(User user) throws Exception {
        UserRow bo = new UserRow();
        bo.setUserId(user.getId());
        bo.setAuthority(user.getAuthority().toString());
        bo.setEnabled(user.getEnabled() ? "Enabled" : "Deactivated");
        bo.setUsername(user.getUsername());
        bo.setEmail(user.getEmail());
        return bo;
    }

    public void deleteButtonAction(UserSearchParam pparam, String buttonAction) {
        if (buttonAction != null && buttonAction.equals("deleteButton")) {
            for (String id : pparam.getSelectedIds()) {
                User user = userDAO.getByID(Integer.parseInt(id));
                user.setEnabled(false);
                userDAO.update(user);
            }
        }
    }

    public void setPageNum(int num) {
        ((UserPaginationDAO) userPaginationDAO).setPageNum(num);
    }
}
