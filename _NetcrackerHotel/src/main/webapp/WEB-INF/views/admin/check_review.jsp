<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>Check review</title>
<link href="<c:url value="/resources/css/hotel.css" />" rel="stylesheet">
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDFgpUSSiedFLKSDnk8J186A52ZJ2UVswk"></script>
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
	.text{
		font-size: x-large;
		color: #1d1e1f;
	}
</style>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<%@include file="../../jsp_elements/_header.jsp"%>
	<div id="wrapper">
		<div class="row">
			<div style="margin: auto" class="col-8">
				<a href="${contextPath}/admin/list_of_reviews"><i class="fa fa-arrow-left" aria-hidden="true"></i> Back to list of
					reviews</a>
				<h3>Review information:</h3>
				<div class="row">
					<div class="col-6">
						<ul class="order">
							<li class="active">
								Rating: <span>${review.rating}</span>
							</li>
							<li class="active">
								Date: <span>${review.date }</span>
							</li>
							<li class="active">
								Username: <span>${review.username }</span>
							</li>
						</ul>
					</div>
					<div class="col-6">
						<ul class="order">
							<li class="active">
								Hotel: <span>${review.hotelname }</span>
							</li>
							<li class="active">
								Status: <span>${review.status }</span>
							</li>
						</ul>
					</div>
				</div>
				<div class="text">
					<h3>Review text:</h3>
					${review.text }
				</div>
				<div class="pull-right">
					<c:if test="${review.status eq 'pending' or review.status eq 'blocked' }">
						<form:form id="approveReview" action="${review.id}"
								   modelAttribute="review" method="post">
							<form:input path="status" type="hidden" name="status"
										value="approved"></form:input>
							<form:button class="btn btn-success" type="submit">Approve</form:button>
						</form:form>
					</c:if>
					<c:if test="${review.status eq 'pending' or review.status eq 'approved' }">
						<form:form id="blockReview" action="${review.id}"
								   modelAttribute="review" method="post">
							<form:input path="status" type="hidden" name="status"
										value="blocked"></form:input>
							<form:button class="btn btn-danger" type="submit">Block</form:button>
						</form:form>
					</c:if>
				</div>
			</div>
		</div>
		<%@include file="../../jsp_elements/_footer.jsp"%>
	</div>
	<script
		src="<c:url value="/resources/bootstrap-4.0.0-alpha.6-dist/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/resources/js/hotel.js"/>"
		type="text/javascript"></script>
</body>
</html>