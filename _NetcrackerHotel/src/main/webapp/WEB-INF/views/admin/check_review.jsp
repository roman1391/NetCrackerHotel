<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>Check review</title>
<link href="<c:url value="/resources/css/hotel.css" />" rel="stylesheet">
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDFgpUSSiedFLKSDnk8J186A52ZJ2UVswk"></script>
</head>

<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<%@include file="../../jsp_elements/_header.jsp"%>
	<div id="wrapper">
		<div class="container">
			<div class="row row-offcanvas row-offcanvas-left">
				<div class="col-xs-12 col-sm-9">
					<div class="jumbotron">

						rating: ${review.rating  }<br> date: ${review.date }<br>
						text: ${review.text }<br> username: ${review.username }<br>
						hotel: ${review.hotelname }<br> status: ${review.status }<br>

							<c:if test="${review.status eq 'pending' or review.status eq 'blocked' }">
								<form:form id="approveReview" action="${review.id}"
										modelAttribute="review" method="post">
										<form:input path="status" type="hidden" name="status"
											value="approved"></form:input>
										<form:button type="submit">Approve</form:button>
									</form:form>
							</c:if>
							<c:if test="${review.status eq 'pending' or review.status eq 'approved' }">
									<form:form id="blockReview" action="${review.id}"
										modelAttribute="review" method="post">
										<form:input path="status" type="hidden" name="status"
											value="blocked"></form:input>
										<form:button type="submit">Block</form:button>
									</form:form>
							</c:if>

						<a href="${contextPath}/admin/list_of_reviews">Back to list of
							reviews</a> <br>
					</div>
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