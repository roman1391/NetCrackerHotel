package by.netcracker.hotel.entities.pagination;

import com.github.paginationspring.bo.BoPaginationResultRow;

public class OrderRow extends BoPaginationResultRow<Integer> {
    private int orderId;

    @Override
    public Integer getPk() {
        return orderId;
    }

}
