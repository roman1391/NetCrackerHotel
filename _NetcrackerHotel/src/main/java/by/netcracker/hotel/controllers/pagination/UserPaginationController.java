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

import by.netcracker.hotel.entities.pagination.UserSearchParam;
import by.netcracker.hotel.services.UserService;
import by.netcracker.hotel.services.impl.pagination.UserPaginationService;

@Controller
@RequestMapping("/admin")
public class UserPaginationController extends PaginationControllerAbstract<UserSearchParam> {
    private static Logger log = Logger.getLogger(UserPaginationController.class);

    private UserPaginationService userPaginationService;
    private UserService userService;

    public UserPaginationController() {
        setOptionWidth(750);
        setDefaultRecordPerPage(10);
        setDefaultSortAscDesc("d");
        setPageLink("/admin/pagination/list_of_users_ajax");
        setAjax(true);
    }

    @Autowired
    public void setPaginationService(UserPaginationService userPaginationService, UserService userService) {
        super.setPaginationService(userPaginationService);
        this.userPaginationService = userPaginationService;
        this.userService = userService;
    }

    @RequestMapping(value = "/list_of_users", method = { RequestMethod.GET, RequestMethod.POST })
    public String defineJsp(@ModelAttribute(PPARAM) UserSearchParam pparam, Model model) throws Exception {
        Map<String, Object> map = assignModel(pparam, null, false);
        model.addAllAttributes(map);
        model.addAttribute("usernames", userService.getUsernames());
        return "admin/pagination/list_of_users";
    }

    @RequestMapping(value = "/list_of_users/{num}", method = { RequestMethod.GET, RequestMethod.POST })
    public String defineJsp(@ModelAttribute(PPARAM) UserSearchParam pparam, @PathVariable("num") int num, Model model)
        throws Exception {
        setDefaultRecordPerPage(num);
        userPaginationService.setPageNum(num);
        Map<String, Object> map = assignModel(pparam, null, false);
        model.addAllAttributes(map);
        model.addAttribute("usernames", userService.getUsernames());
        return "admin/pagination/list_of_users";
    }

    @RequestMapping(value = "pagination/list_of_users_ajax", method = { RequestMethod.GET, RequestMethod.POST })
    public String defineAjaxJsp(@ModelAttribute(PPARAM) UserSearchParam pparam,
        @RequestParam(value = BUTTON_ACTION, required = false) String buttonAction, Model model) throws Exception {
        userPaginationService.deleteButtonAction(pparam, buttonAction);
        Map<String, Object> map = assignModel(pparam, buttonAction);
        model.addAllAttributes(map);
        return "admin/pagination/list_of_users_ajax";
    }

}