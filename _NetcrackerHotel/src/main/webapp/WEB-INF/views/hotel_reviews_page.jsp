<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Hotel reviews</title>
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
                    <c:if test="${fn:length(currentReviews) eq 0}">
                        There is no any review left yet <br>
                    </c:if>
                    <c:if test="${fn:length(currentReviews) gt 0}">
					<c:forEach var="review" items="${currentReviews}">
					rating: ${review.rating }<br>
					text: ${review.text }<br>
					date: ${review.date }<br>
					userId: ${review.userId }<br>
					hotelId: ${review.hotelId }<br>
					status: ${review.status }<br>
					<br>	
					</c:forEach>
					<a href="${contextPath}/hotel_page/${currentReviews[0].hotelId}">Back to hotel page </a>
					</c:if>
					
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