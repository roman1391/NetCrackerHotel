<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Hotel page</title>
    <link href="<c:url value="/resources/css/hotel.css" />" rel="stylesheet">
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDFgpUSSiedFLKSDnk8J186A52ZJ2UVswk"></script>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@include file="../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <div class="container">
        <div class="row row-offcanvas row-offcanvas-left">
            <div class="col-xs-12 col-sm-9">
                <div class="jumbotron">
                    <h4 style="text-align: center">${choosenHotel.name }
                    <c:forEach var="i" begin="1" end="${choosenHotel.typeOfService}">
                        <i class="fa fa-star"></i>
                    </c:forEach>
                    </h4>
                    <%@include file="../jsp_elements/map.jsp" %>


                    <c:if test="${success!=null}">
                        <div style="margin: 50px" class="alert alert-success">
                                ${success}</div>
                    </c:if>

                    <%@include file="../jsp_elements/photoCarousel.jsp" %>


                    Description: ${choosenHotel.description }<br>

                    <c:choose>
                        <c:when test="${reviewInfo eq 'forbidden'}">
                            <div style="margin: 10px" class="alert alert-danger">
                                To leave a review please log in
                            </div>
                        </c:when>
                        <c:when test="${reviewInfo eq 'notExist'}">
                         <sec:authorize access="hasAnyRole('ADMIN','USER',
            				'TWITTER_USER','VKONTAKTE_USER','FACEBOOK_USER')">
                            <form:form method="post" id="review" action="review_page" modelAttribute="choosenHotel">
                                <form:input path="id" type="hidden" name="id" value="${hotel.id}"></form:input>
                                <form:button type="submit">Leave review</form:button>
                            </form:form>
                             </sec:authorize>
                        </c:when>
                        <c:when test="${reviewInfo eq 'exist'}">
                            <div style="margin: 10px" class="alert alert-success">
                                You have already left review
                            </div>
                        </c:when>                          
                    </c:choose>
                    
                    <form:form method="post" id="review" action="${contextPath}/hotel_page/all_reviews" modelAttribute="choosenHotel">
                        <form:input path="id" type="hidden" name="id" value="${hotel.id}"></form:input>
                        <form:button type="submit">See all reviews </form:button>
                    </form:form>
                    
                    <sec:authorize access="hasAnyRole('ADMIN','USER',
            				'TWITTER_USER','VKONTAKTE_USER','FACEBOOK_USER')">
                    <table>
                        <tbody>
                        <c:forEach items="${hotel_rooms}" var="room" varStatus="loop">
                            <tr>
                                <td>Room ID: ${room.id}  </td>
                                <td>Cost: ${room.cost}  </td>
                                <td>Capacity: ${room.capacity}  </td>
                                <td>Hotel ID: ${room.hotelID}  </td>
                                <c:if test="${currentUser.authority.toString() ne 'GUEST' or currentUser.authority.toString() ne 'BLOCKED'}">
                                    <td>
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
                                            <form:button type="submit">Book</form:button>
                                        </form:form>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <a href="${contextPath}/admin/hotel/${id}/edit_hotel" class = "btn btn-primary">Edit hotel</a>
                        <a href="${contextPath}/admin/hotel/${id}/edit_photo" class = "btn btn-primary">Edit photos</a>
                        <a href="${contextPath}/admin/hotel/${id}/edit_room" class = "btn btn-primary">Edit rooms</a>
                    </sec:authorize>
                </div>
            </div>


        </div>
    </div>
    <%@include file="../jsp_elements/_footer.jsp" %>
</div>
<script src="<c:url value="/resources/bootstrap-4.0.0-alpha.6-dist/js/bootstrap.js"/>"></script>
<script src="<c:url value="/resources/js/hotel.js"/>" type="text/javascript"></script>
</body>
</html>