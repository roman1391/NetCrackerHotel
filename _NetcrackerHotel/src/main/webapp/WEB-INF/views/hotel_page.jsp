<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Hotel page</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link
	href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
	rel="stylesheet">
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<%@include file="../jsp_elements/_header.jsp"%>
	<div id="wrapper">
		<div class="container">
			<div class="row row-offcanvas row-offcanvas-left">
				<div class="col-xs-12 col-sm-9">
					<div class="jumbotron">
						<h3>Hotel page</h3>

						<c:if test="${success!=null}">
							<div style="margin: 50px" class="alert alert-success">
								${success}</div>
						</c:if>

                    Name: ${choosenHotel.name }<br>
                    Country: ${choosenHotel.country }<br> City: ${choosenHotel.city}<br>
                    Address: ${choosenHotel.address }<br> typeOfService: ${choosenHotel.typeOfService }<br>
                    Description: ${choosenHotel.description }<br>
                    mainPhoto: ${choosenHotel.mainPhoto }<br>

                        <c:choose>
                            <c:when test="${reviewInfo eq 'forbidden'}">
                                <div style="margin: 10px" class="alert alert-danger" >
                                    To leave a review please log in </div>
                            </c:when>
                            <c:when test="${reviewInfo eq 'notExist'}">
                                <form:form method="post" id="review" action="review_page" modelAttribute="choosenHotel">
                                    <form:input path="id" type="hidden" name="id" value="${hotel.id}"></form:input>
                                    <form:button type="submit">Leave review</form:button>
                                </form:form>
                            </c:when>
                            <c:when test="${reviewInfo eq 'exist'}">
                                <div style="margin: 10px" class="alert alert-success" >
                                    You have already left review </div>
                            </c:when>
                            <c:when test="${reviewInfo eq 'moderate'}">
                                <form:form method="post" id="review" action="list_of_reviews" modelAttribute="choosenHotel">
                                    <form:input path="id" type="hidden" name="id" value="${hotel.id}"></form:input>
                                    <form:button type="submit">See all reviews (not work yet)</form:button>
                                </form:form>
                            </c:when>
                        </c:choose>
                    <table>
                        <tbody>
                        <c:forEach items="${hotel_rooms}" var="room" varStatus="loop">
                            <tr>
                                <td>${room.id}</td>
                                <td>${room.cost}</td>
                                <td>${room.capacity}</td>
                                <td>${room.hotelID}</td>
                                <c:if test="${currentUser.authority.toString() ne 'GUEST'}">
                                    <td>
                                        <form:form method="post" id="order" action="${contextPath}/book_page" modelAttribute="order">
                                            <form:input path="userId" type="hidden" name="userId" value="${currentUser.id}"></form:input>
                                            <form:input path="roomId" type="hidden" name="roomId" value="${room.id}"></form:input>
                                            <form:button type="submit">Book</form:button>
                                        </form:form>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>


        </div>
    </div>
    <%@include file="../jsp_elements/_footer.jsp" %>
</div>

</body>
</html>