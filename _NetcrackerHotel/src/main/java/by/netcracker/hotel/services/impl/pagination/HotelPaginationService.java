package by.netcracker.hotel.services.impl.pagination;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.paginationspring.bo.BoPaginationColumn;
import com.github.paginationspring.dao.PaginationDao;
import com.github.paginationspring.service.PaginationServiceAbstract;

import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.dao.UserDAO;
import by.netcracker.hotel.dao.pagination.HotelPaginationDAO;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.pagination.HotelRow;
import by.netcracker.hotel.entities.pagination.HotelSearchParam;

@Service
public class HotelPaginationService extends PaginationServiceAbstract<HotelSearchParam, HotelRow, Hotel> {

    private static Logger log = Logger.getLogger(HotelPaginationService.class);

    private PaginationDao<Hotel, HotelSearchParam> hotelPaginationDAO;
    private HotelDAO hotelDAO;

    @Autowired
    public void setPaginationDao(HotelPaginationDAO hotelPaginationDAO, UserDAO userDAO, HotelDAO hotelDAO) {
        super.setPaginationDao(hotelPaginationDAO);
        this.hotelPaginationDAO = hotelPaginationDAO;
        this.hotelDAO = hotelDAO;
    }

    @Override
    public void assignColumnsDefinition(List<BoPaginationColumn> columns) throws Exception {

        log.debug("setting columns def.");
        BoPaginationColumn col = null;

        col = new BoPaginationColumn();
        col.setColumnName("Name");
        col.setOrderColumns("name");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Class");
        col.setOrderColumns("typeOfService");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("State");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Country");
        col.setOrderColumns("country");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("City");
        col.setOrderColumns("city");
        col.setOrderDirections("desc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Page");
        col.setWidth(30);
        columns.add(col);

    }

    @Override
    protected HotelRow assignDataToBo(Hotel hotel) throws Exception {

        HotelRow bo = new HotelRow();
        bo.setHotelId(hotel.getId());
        bo.setName(hotel.getName());
        bo.setTypeOfService(String.valueOf(hotel.getTypeOfService()));
        bo.setEnabled(hotel.getEnabled() ? "Enabled" : "Deactivated");
        bo.setCountry(hotel.getCountry());
        bo.setCity(hotel.getCity());
        return bo;
    }

    public void deleteButtonAction(HotelSearchParam pparam, String buttonAction) {
        if (buttonAction != null && buttonAction.equals("deleteButton")) {
            for (String id : pparam.getSelectedIds()) {
                Hotel hotel = hotelDAO.getByID(Integer.parseInt(id));
                hotel.setEnabled(false);
                hotelDAO.update(hotel);
            }
        }
    }

    public void setPageNum(int num) {
        ((HotelPaginationDAO) hotelPaginationDAO).setPageNum(num);
    }
}
