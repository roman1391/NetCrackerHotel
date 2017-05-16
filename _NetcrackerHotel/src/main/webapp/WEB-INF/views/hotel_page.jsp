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
    <div class="container-fluid">
        <div class="row">
            <div style="margin: 0 auto" class="col-10">
                <div class="hotelwrap">
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

                    <div style="margin-top: 10px;" id="description" class="container">
                        <h1 style="color: #2b2b2b">Description:</h1>
                        <p>${choosenHotel.description}</p>
                    </div>

                    <div style="float:right" class="btn-group">
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
                                            <form:button class="btn btn-primary" type="submit">Leave review</form:button>
                                        </form:form>
                                    </sec:authorize>
                                </c:when>
                            <c:when test="${reviewInfo eq 'exist'}">
                                <div style="margin: 10px" class="alert alert-success">
                                    You have already left review
                                </div>
                            </c:when>
                        </c:choose>
                        <div style="margin-left: 10px" class="d-inline-block">
                            <form:form method="post" id="review" action="${contextPath}/hotel_page/all_reviews" modelAttribute="choosenHotel">
                                <form:input path="id" type="hidden" name="id" value="${hotel.id}"></form:input>
                                <form:button class="btn btn-edit" type="submit">See all reviews </form:button>
                            </form:form>
                        </div>
                        <sec:authorize access="hasAnyRole('ADMIN','USER',
            				'TWITTER_USER','VKONTAKTE_USER','FACEBOOK_USER')">
                        <div style="margin-left: 10px" class="d-inline-block">
                            <a href="${contextPath}/rooms?id=${choosenHotel.id}" class="btn btn-warning" >Book room</a>
                        </div>
                        </sec:authorize>
                    </div>
                    <div class="clearfix"></div>

                    <sec:authorize access="hasAnyRole('ADMIN','USER',
            				'TWITTER_USER','VKONTAKTE_USER','FACEBOOK_USER')">
                    <table>
                        <tbody>

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