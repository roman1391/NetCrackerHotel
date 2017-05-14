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
        <img src="${currentUser.getAvatar()}" class="img-responsive" alt="">
    </div>
    <div class="profile-usertitle">
        <div class="profile-usertitle-name">
            ${currentUser.getLastName()} ${currentUser.getFirstName()}
        </div>
    </div>
    <div class="profile-usermenu">
        <ul >
            <li>
                <a href="/profile">
                    <i class="fa fa-user-circle" aria-hidden="true"></i>  Profile </a>
            </li>
            <li>
                <a href="/booked_room?id=${currentUser.getId()}">
                    <i class="fa fa-archive" aria-hidden="true"></i>
                     Booked room
                </a>
            </li>
        </ul>
    </div>
</div>

