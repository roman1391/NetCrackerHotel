<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Hotel page</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />" rel="stylesheet">
</head>

<body>
<%@include file="../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <div class="container">
        <div class="row row-offcanvas row-offcanvas-left">
            <div class="col-xs-12 col-sm-9">
                <div class="jumbotron">
                    <h3>Hotel page</h3>
                    Name: ${hotel.name }<br>
                    Country: ${hotel.country }<br>
                    City: ${hotel.city}<br>
                    Address: ${hotel.address }<br>
                    typeOfService: ${hotel.typeOfService }<br>
                    Description: ${hotel.description }<br>
                    photoURL: ${hotel.photoURL }<br>
                    <form:form method="post" id="feedback" action="feedback_page" modelAttribute="choosenHotel" >
						<form:input path="id" type="hidden" name="id" value="${hotel.id}"></form:input>
						<form:button type="submit">Leave feedback</form:button>
					</form:form>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../jsp_elements/_footer.jsp" %>
</div>
</body>
</html>