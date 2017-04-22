package by.netcracker.hotel.dao.impl.pagination;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.paginationspring.bo.BoPaginationParam;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.entities.User;

@Repository
public class UserPaginationDAO implements com.github.paginationspring.dao.PaginationDao {
    UserDAO userDAO;

    @Autowired
    public UserPaginationDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public int retrieveCountResult(BoPaginationParam pparam) throws Exception {
        List<User> list = userDAO.getAll();
        return list.size();
    }

    @Override
    public List retrievePageResult(BoPaginationParam pparam) throws Exception {
        List<User> list = userDAO.getAll();
        List<User> list1 = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            list1.add(list.get(i));
        }
        return list1;
    }

}
