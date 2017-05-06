package by.netcracker.hotel.services.impl.pagination;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.paginationspring.bo.BoPaginationColumn;
import com.github.paginationspring.dao.PaginationDao;
import com.github.paginationspring.service.PaginationServiceAbstract;

import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.dao.ReviewDAO;
import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.dao.pagination.ReviewPaginationDAO;
import by.netcracker.hotel.entities.Review;
import by.netcracker.hotel.entities.pagination.ReviewRow;
import by.netcracker.hotel.entities.pagination.ReviewSearchParam;

@Service
public class ReviewPaginationService extends PaginationServiceAbstract<ReviewSearchParam, ReviewRow, Review> {

    private static Logger log = Logger.getLogger(UserPaginationService.class);

    @SuppressWarnings("unused")
    private PaginationDao<Review, ReviewSearchParam> reviewPaginationDAO;
    private ReviewDAO reviewDAO;
    private HotelDAO hotelDAO;

    @Autowired
    public void setPaginationDao(ReviewPaginationDAO reviewPaginationDAO, ReviewDAO reviewDAO, UserDAO userDAO,
        HotelDAO hotelDAO) {
        super.setPaginationDao(reviewPaginationDAO);
        this.reviewPaginationDAO = reviewPaginationDAO;
        this.reviewDAO = reviewDAO;
        this.hotelDAO = hotelDAO;
    }

    @Override
    public void assignColumnsDefinition(List<BoPaginationColumn> columns) throws Exception {
        log.debug("setting columns def.");

        BoPaginationColumn col = null;

        col = new BoPaginationColumn();
        col.setColumnName("Status");
        col.setOrderColumns("status");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Username");
        col.setOrderColumns("username");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Hotelname");
        col.setOrderColumns("hotelname");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Time");
        col.setOrderColumns("time");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Review");
        col.setWidth(30);
        columns.add(col);

    }

    @Override
    protected ReviewRow assignDataToBo(Review review) throws Exception {
        ReviewRow bo = new ReviewRow();
        bo.setReviewId(review.getId());
        bo.setUsername(review.getUsername());
        bo.setHotelname(hotelDAO.getByID(review.getHotelId()).getName());
        bo.setTime(review.getDate());
        bo.setStatus(review.getStatus());
        return bo;
    }

    public void deleteButtonAction(ReviewSearchParam pparam, String buttonAction) {
        if (buttonAction != null && buttonAction.equals("deleteButton")) {
            for (String id : pparam.getSelectedIds()) {
                reviewDAO.deleteByID(Integer.parseInt(id));
            }
        }
    }

}
