<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 16.05.17
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="../../resources/css/adminnav.css" />" rel="stylesheet">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="container sidenav-outer">
    <div class="sidenav">
        <ul class="nav flex-column" id="adminNav">
            <li class="nav-item">
                <a class="nav-link active" href="${contextPath}/admin/list_of_users">
                    <i class="fa fa-users" aria-hidden="true"></i> User management</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/admin/list_of_hotels">
                    <i class="fa fa-bed" aria-hidden="true"></i> Hotels management</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/admin/list_of_orders">
                    <i class="fa fa-list-alt" aria-hidden="true"></i> Orders management</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/admin/list_of_reviews">
                    <i class="fa fa-newspaper-o" aria-hidden="true"></i> Reviews management</a>
            </li>
        </ul>
    </div>
</div>

