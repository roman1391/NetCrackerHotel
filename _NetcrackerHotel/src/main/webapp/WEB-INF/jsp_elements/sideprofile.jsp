<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 13.05.17
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link  type ="text/css" href="<c:url value="../../resources/css/profilesidebar.css" />" rel="stylesheet" />
<div class="profile-sidebar">
    <div class="profile-userpic">
        <img src="${currentUser.getAvatar()}" class="img-responsive" alt="image">
    </div>
    <div class="profile-usertitle">
        <div class="profile-usertitle-name">
            ${currentUser.getLastName()} ${currentUser.getFirstName()}
        </div>
    </div>
    <div class="profile-usermenu">
        <ul >
            <sec:authorize access="hasRole('ADMIN')">
                <li>
                   <a href="/admin/admin_page">
                       <i class="fa fa-cog" aria-hidden="true"></i>  Admin page
                   </a>
                </li>
            </sec:authorize>
            <li>
                <a href="profile">
                    <i class="fa fa-user-circle" aria-hidden="true"></i>  Profile </a>
            </li>
            <li>
                <a href="booked_room?id=${currentUser.getId()}">
                    <i class="fa fa-archive" aria-hidden="true"></i>
                     Booked room
                </a>
            </li>
            <li>
                <a href="feedback">
                    <i class="fa fa-envelope" aria-hidden="true"></i>
                    Feedback
                </a>
            </li>
        </ul>
    </div>
</div>

