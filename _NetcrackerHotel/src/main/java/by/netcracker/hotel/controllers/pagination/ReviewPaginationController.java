package by.netcracker.hotel.controllers.pagination;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.paginationspring.controller.PaginationControllerAbstract;

import by.netcracker.hotel.entities.pagination.ReviewSearchParam;
import by.netcracker.hotel.services.impl.pagination.ReviewPaginationService;

@Controller
@RequestMapping("/admin")
public class ReviewPaginationController extends PaginationControllerAbstract<ReviewSearchParam> {
    private static Logger log = Logger.getLogger(ReviewPaginationController.class);

    private ReviewPaginationService reviewPaginationService;

    public ReviewPaginationController() {
        setOptionWidth(750);
        setDefaultRecordPerPage(10);
        setDefaultSortAscDesc("d");
        setPageLink("/admin/pagination/list_of_reviews_ajax");
        setAjax(true);
    }

    @Autowired
    public void setPaginationService(ReviewPaginationService reviewPaginationService) {
        super.setPaginationService(reviewPaginationService);
        this.reviewPaginationService = reviewPaginationService;
    }

    @RequestMapping(value = "/list_of_reviews", method = { RequestMethod.GET, RequestMethod.POST })
    public String defineJsp(@ModelAttribute(PPARAM) ReviewSearchParam pparam, Model model) throws Exception {
        Map<String, Object> map = assignModel(pparam, null, false);
        model.addAllAttributes(map);
        return "admin/pagination/list_of_reviews";
    }

    @RequestMapping(value = "/list_of_reviews/{num}", method = { RequestMethod.GET, RequestMethod.POST })
    public String defineJsp(@ModelAttribute(PPARAM) ReviewSearchParam pparam, @PathVariable("num") int num, Model model)
        throws Exception {
        setDefaultRecordPerPage(num);
        reviewPaginationService.setPageNum(num);
        Map<String, Object> map = assignModel(pparam, null, false);
        model.addAllAttributes(map);
        return "admin/pagination/list_of_reviews";
    }

    @RequestMapping(value = "pagination/list_of_reviews_ajax", method = { RequestMethod.GET, RequestMethod.POST })
    public String defineAjaxJsp(@ModelAttribute(PPARAM) ReviewSearchParam pparam,
        @RequestParam(value = BUTTON_ACTION, required = false) String buttonAction, Model model) throws Exception {
        reviewPaginationService.deleteButtonAction(pparam, buttonAction);
        Map<String, Object> map = assignModel(pparam, buttonAction);
        model.addAllAttributes(map);
        return "admin/pagination/list_of_reviews_ajax";
    }

}