package by.netcracker.hotel.controllers.pagination;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.paginationspring.controller.PaginationControllerAbstract;

import by.netcracker.hotel.entities.pagination.UserSearchParam;
import by.netcracker.hotel.services.impl.pagination.UserPaginationService;

@Controller
public class UserPaginationController extends PaginationControllerAbstract<UserSearchParam> {
    private static Logger log = Logger.getLogger(UserPaginationController.class);

    private UserPaginationService userPaginationService;

    public UserPaginationController() {
        setOptionDisplayCheckbox(true);
        setOptionDisplaySerialNo(true);
        setOptionWidth(750);
        setDefaultRecordPerPage(10);
        setDefaultSortAscDesc("d");
        setPageLink("/list_of_users"); // url
    }

    @Autowired
    public void setPaginationService(UserPaginationService userPaginationService) {
        super.setPaginationService(userPaginationService);
        this.userPaginationService = userPaginationService;
    }

    @RequestMapping(value = "/list_of_users", method = { RequestMethod.GET, RequestMethod.POST })
    public String defineJsp(@ModelAttribute(PPARAM) UserSearchParam pparam,
        @RequestParam(value = BUTTON_ACTION, required = false) String buttonAction, Model model) throws Exception {
        userPaginationService.deleteButtonAction(pparam, buttonAction);
        Map<String, Object> map = assignModel(pparam, buttonAction);
        model.addAllAttributes(map);
        return "list_of_users";
    }

}
