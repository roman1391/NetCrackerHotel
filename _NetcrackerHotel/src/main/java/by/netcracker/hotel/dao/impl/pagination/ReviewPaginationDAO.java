package by.netcracker.hotel.dao.impl.pagination;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.ReviewDAO;
import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.entities.pagination.ReviewSearchParam;

@Repository
public class ReviewPaginationDAO implements com.github.paginationspring.dao.PaginationDao<Review, ReviewSearchParam> {
    ReviewDAO reviewDAO;

    @Autowired
    public ReviewPaginationDAO(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

    @Override
    public int retrieveCountResult(ReviewSearchParam pparam) throws Exception {
        ReviewSearchParam param = (ReviewSearchParam) pparam;
        List<Review> list = reviewDAO.getAll();
        // list = filterList(list, param);
        return list.size();

    }

    @Override
    public List<Review> retrievePageResult(ReviewSearchParam pparam) throws Exception {
        List<Review> list = reviewDAO.getAll();
        int index = Integer.parseInt(pparam.getResultIndex());
        ReviewSearchParam param = (ReviewSearchParam) pparam;

        // sortList(list, param);
        // list = filterList(list, param);
        List<Review> list1 = getOnePage(list, index);
        return list1;
    }

    private List<Review> getOnePage(List<Review> list, int index) {
        List<Review> list1 = new ArrayList<Review>();
        for (int i = index; i < index + 10; i++) {
            if (list.size() > i) {
                list1.add(list.get(i));
            }
        }
        return list1;
    }

}
