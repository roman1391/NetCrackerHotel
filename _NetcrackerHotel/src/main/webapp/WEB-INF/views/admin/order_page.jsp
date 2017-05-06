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
	<jsp:include page="/WEB-INF/jsp_elements/_header.jsp"></jsp:include>
	<div id="wrapper">
		<div class="container">
			<div class="row row-offcanvas row-offcanvas-left">
				<div class="col-xs-12 col-sm-9">
					<div class="jumbotron">
						<h3>Order:</h3>
						Order Id: ${order.id} <br>
						Room Id: ${order.roomId} <br>
						UserId: ${order.userId} <br>
						First Name: ${order.firstName } <br>
						LastName: ${order.lastName } <br>
						Arrival Date:${order.arrivalDate} <br>
						Leave Date: ${order.leaveDate} <br>
						Pay value: ${order.payValue} <br>

						<form:form method="post" id="order"
							action="${contextPath}/admin/order_deleted/${order.id}"
							modelAttribute="orderr">
							<form:input path="userId" type="hidden" name="userId"
								value="${order.userId}"></form:input>
							<form:button type="submit">Delete order</form:button>
						</form:form>
						
						<a href="${contextPath}/admin/list_of_orders">Back to list of orders</a> <br> 
						<a href="${contextPath}/admin/admin_page">To admin page</a>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/jsp_elements/_footer.jsp"></jsp:include>
	</div>
</body>
</html>