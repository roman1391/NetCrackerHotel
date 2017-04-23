package by.netcracker.hotel.dao.impl.pagination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.entities.User;
import by.netcracker.hotel.entities.pagination.UserSearchParam;

@Repository
public class UserPaginationDAO implements com.github.paginationspring.dao.PaginationDao<User, UserSearchParam> {
    UserDAO userDAO;

    @Autowired
    public UserPaginationDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public int retrieveCountResult(UserSearchParam pparam) throws Exception {
        UserSearchParam param = (UserSearchParam) pparam;
        List<User> list = userDAO.getAll();
        if (param.getAuthority() != null && !param.getAuthority().equals("")) {
            List<User> list1 = new ArrayList<User>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getAuthority().toString().equals(param.getAuthority())) {
                    list1.add(list.get(i));
                }
            }
            list = list1;
        }
        if (param.getEnabled() != null && !param.getEnabled().equals("")) {
            List<User> list1 = new ArrayList<User>();
            for (int i = 0; i < list.size(); i++) {
                if (((Boolean) list.get(i).getEnabled()).toString().equals(param.getEnabled())) {
                    list1.add(list.get(i));
                }
            }
            list = list1;
        }
        if (param.getUsername() != null && !param.getUsername().equals("")) {
            List<User> list1 = new ArrayList<User>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUsername().contains((param.getUsername()))) {
                    list1.add(list.get(i));
                }
            }
            list = list1;
        }
        return list.size();
    }

    @Override
    public List<User> retrievePageResult(UserSearchParam pparam) throws Exception {
        List<User> list = userDAO.getAll();
        int index = Integer.parseInt(pparam.getResultIndex());
        UserSearchParam param = (UserSearchParam) pparam;

        if (param.getSortName() != null && !param.getSortName().equals("")) {
            System.out.println(param.getSortName());
            if (param.getSortName().equals("Username")) {
                if (param.getSortAscDesc().equals("d")) {
                    Collections.sort(list, new Comparator<User>() {
                        @Override
                        public int compare(User user1, User user2) {
                            return user1.getUsername().compareTo(user2.getUsername());
                        }
                    });
                } else if (param.getSortAscDesc().equals("a")) {
                    Collections.sort(list, new Comparator<User>() {

                        @Override
                        public int compare(User user1, User user2) {
                            return user2.getUsername().compareTo(user1.getUsername());
                        }
                    });
                }
            } else if (param.getSortName().equals("Authority")) {
                if (param.getSortAscDesc().equals("d")) {
                    Collections.sort(list, new Comparator<User>() {
                        @Override
                        public int compare(User user1, User user2) {
                            return user1.getAuthority().toString().compareTo(user2.getAuthority().toString());
                        }
                    });
                } else if (param.getSortAscDesc().equals("a"))

                {
                    Collections.sort(list, new Comparator<User>() {
                        @Override
                        public int compare(User user1, User user2) {
                            return user2.getAuthority().toString().compareTo(user1.getAuthority().toString());
                        }
                    });
                }
            }
        }

        if (param.getAuthority() != null && !param.getAuthority().equals("")) {
            List<User> list1 = new ArrayList<User>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getAuthority().toString().equals(param.getAuthority())) {
                    list1.add(list.get(i));
                }
            }
            list = list1;
        }
        if (param.getEnabled() != null && !param.getEnabled().equals("")) {
            List<User> list1 = new ArrayList<User>();
            for (int i = 0; i < list.size(); i++) {
                if (((Boolean) list.get(i).getEnabled()).toString().equals(param.getEnabled())) {
                    list1.add(list.get(i));
                }
            }
            list = list1;
        }
        if (param.getUsername() != null && !param.getUsername().equals("")) {
            List<User> list1 = new ArrayList<User>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUsername().contains((param.getUsername()))) {
                    list1.add(list.get(i));
                }
            }
            list = list1;
        }

        List<User> list1 = new ArrayList<User>();
        for (int i = index; i < index + 10; i++) {
            if (list.size() > i) {
                list1.add(list.get(i));
            }
        }
        return list1;
    }

}
