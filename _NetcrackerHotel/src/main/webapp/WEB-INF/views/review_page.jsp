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
                    <h3>Review page</h3>

                    <form:form method="post" id="review" action="send_review" modelAttribute="review" >
	 					Your rating:
	 					<form:select path="rating"  >
                           <form:option value="${1}" label="1"/>
                           <form:option value="${2}" label="2"/>
                           <form:option value="${3}" label="3"/>
                           <form:option value="${4}" label="4"/>
                           <form:option value="${5}" label="5"/>
                           <form:option value="${6}" label="6"/>
                           <form:option value="${7}" label="7"/>
                           <form:option value="${8}" label="8"/>
                           <form:option value="${9}" label="9"/>
                           <form:option value="${10}" label="10"/>
                        </form:select> <br>
                        <form:input path="text" type="text" name="text" ></form:input> <br>
	 					<form:input path="userId" type="hidden" name="userId" value="${currentUser.id}"></form:input>
						<form:input path="hotelId" type="hidden" name="hotelId" value="${choosenHotel.id}"></form:input>
						<form:button type="submit">Send review</form:button>
					</form:form>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../jsp_elements/_footer.jsp" %>
</div>
</body>
</html>