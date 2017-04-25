package by.netcracker.hotel.dao.impl.pagination;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.entities.pagination.ReviewSearchParam;

@Repository
public class ReviewPaginationDAO implements com.github.paginationspring.dao.PaginationDao<Review, ReviewSearchParam> {

    @Override
    public int retrieveCountResult(ReviewSearchParam pparam) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Review> retrievePageResult(ReviewSearchParam pparam) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
