<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Hotel page</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link
	href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
	rel="stylesheet">
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
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<jsp:include page="/WEB-INF/jsp_elements/_header.jsp" />
	<div id="wrapper">
		<div class="row">
			<div style="margin: auto" class="col-8">
				<a href="${contextPath}/admin/list_of_orders"><i class="fa fa-arrow-left" aria-hidden="true"></i> Back to list of orders</a>
				<h3>Order:</h3>
				<div class="row">
					<div class="col-3">
                        <ul class="order">
							<li class="active">
								Order Id: <span>${order.id}</span>
							</li>
							<li class="active">
								Room Id: <span>${order.roomId}</span>
							</li>
							<li class="active">
								UserId: <span>${order.userId}</span>
							</li>
						</ul>
					</div>
					<div class="col-3">
						<ul class="order">
							<li class="active">
								First Name: <span>${order.firstName }</span>
							</li>
							<li class="active">
								LastName: <span>${order.lastName }</span>
							</li>
						</ul>
					</div>
					<div class="col-6">
						<ul class="order">
							<li class="active">
								Arrival Date:<span>${order.arrivalDate}</span>
							</li>
							<li class="active">
								Leave Date: <span>${order.leaveDate}</span>
							</li>
							<li class="active">
								Pay value: <span>${order.payValue}</span>
							</li>
						</ul>
					</div>
				</div>
				<form:form class="pull-right" method="post" id="order"
						   action="${contextPath}/admin/order_deleted/${order.id}"
						   modelAttribute="orderr">
					<form:input path="userId" type="hidden" name="userId"
								value="${order.userId}"></form:input>
					<form:button type="submit" class="btn btn-primary">Delete order</form:button>
				</form:form>
			</div>
		</div>
		<jsp:include page="/WEB-INF/jsp_elements/_footer.jsp" />
	</div>
</body>
</html>