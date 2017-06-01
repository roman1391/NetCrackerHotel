<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Hotel editing page</title>
    <link href="<c:url value="/resources/css/hotel.css" />" rel="stylesheet">
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDFgpUSSiedFLKSDnk8J186A52ZJ2UVswk"></script>
</head>
<style>
    .order{
        font-size: x-large;
        color: #1d1e1f;
        list-style: none;
    }
    .order span{
        color: #2a62bc;
    }
</style>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@include file="../../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <div class="row">
        <div style="margin: auto" class="col-9">
            <p><a href="${contextPath}/admin/list_of_hotels"><i class="fa fa-arrow-left" aria-hidden="true"></i>Back to hotels management</a></p>
            <h4 style="text-align: center">${choosenHotel.name }
                <c:forEach var="i" begin="1" end="${choosenHotel.typeOfService}">
                        <i class="fa fa-star"></i>
                </c:forEach>
            </h4>
            <%@include file="../../jsp_elements/map.jsp" %>


            <c:if test="${success!=null}">
                <div style="margin: 10px" class="alert alert-success">
                        ${success}</div>
            </c:if>

            <%@include file="../../jsp_elements/photoCarousel.jsp" %>

            <h4>Description:</h4>
            <div style="font-size: x-large; margin-top: 10px; margin-bottom: 10px">
                ${choosenHotel.description }
            </div>

            <c:forEach items="${hotel_rooms}" var="room" varStatus="loop">
                    <ul class="order list-inline">
                        <li class="list-inline-item">
                            Room №": <span>${room.id}</span>
                        </li>
                        <li class="list-inline-item">
                            Cost: <span>${room.cost}</span>
                        </li>
                        <li class="list-inline-item">
                            Capacity: <span>${room.capacity}</span>
                        </li>
                    </ul>
                <c:if test="${currentUser.authority.toString() ne 'GUEST' or currentUser.authority.toString() ne 'BLOCKED'}">
                    <form:form method="post" id="order" action="${contextPath}/book_page/${room.id}"
                                                   modelAttribute="order">
                        <form:input path="userId" type="hidden" name="userId"
                                                        value="${currentUser.id}"></form:input>
                        <form:input path="username" type="hidden" name="username"
                                                        value="${currentUser.username}"></form:input>
                        <form:input path="roomId" type="hidden" name="roomId"
                                                        value="${room.id}"></form:input>
                        <form:input path="hotelname" type="hidden" name="hotelname"
                                                        value="${choosenHotel.name}"></form:input>
                    </form:form>
                </c:if>
            </c:forEach>

            <div class="pull-right">
                <a href="${contextPath}/admin/hotel/${id}/edit_hotel" class = "btn btn-primary">Edit hotel</a>
                <a href="${contextPath}/admin/hotel/${id}/edit_photo" class = "btn btn-primary">Edit photos</a>
                <a href="${contextPath}/admin/hotel/${id}/edit_room" class = "btn btn-primary">Edit rooms</a>
            </div>
        </div>
    </div>
    <%@include file="../../jsp_elements/_footer.jsp" %>
</div>
<script src="<c:url value="/resources/bootstrap-4.0.0-alpha.6-dist/js/bootstrap.js"/>"></script>
<script src="<c:url value="/resources/js/hotel.js"/>" type="text/javascript"></script>
</body>
</html>