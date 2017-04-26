package by.netcracker.hotel.dao.impl.pagination;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.paginationspring.bo.BoPaginationParam;

import by.netcracker.hotel.dao.AbstractDAO;

public abstract class AbstractPaginationJdbcDAO<E, P extends BoPaginationParam>
    implements com.github.paginationspring.dao.PaginationDao<E, P> {

    AbstractDAO<E, Integer> dao;

    @Autowired
    public AbstractPaginationJdbcDAO(AbstractDAO<E, Integer> dao) {
        this.dao = dao;
    }

    @Override
    public int retrieveCountResult(P pparam) throws Exception {
        List<E> list = dao.getAll();
        list = filterList(list, pparam);
        return list.size();
    }

    @Override
    public List<E> retrievePageResult(P pparam) throws Exception {
        List<E> list = dao.getAll();
        int index = Integer.parseInt(pparam.getResultIndex());

        sortList(list, pparam);
        list = filterList(list, pparam);
        List<E> list1 = getOnePage(list, index);
        return list1;
    }

    private List<E> getOnePage(List<E> list, int index) {
        List<E> list1 = new ArrayList<E>();
        for (int i = index; i < index + 10; i++) {
            if (list.size() > i) {
                list1.add(list.get(i));
            }
        }
        return list1;
    }

    protected abstract void sortList(List<E> list, P param);

    protected abstract List<E> filterList(List<E> list, P param);
}
