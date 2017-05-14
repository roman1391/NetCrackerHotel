<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Home</title>
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
				Admin page! <br />
				<div class="col-xs-12 col-sm-9">
					<div class="jumbotron">
						<h2>Admin page</h2>
						<c:if test="${success!=null}">
							<div style="margin: 50px" class="alert alert-success">
								${success}</div>
						</c:if>
						<p><a href="${contextPath}/admin/list_of_users">User management</a></p>
						<p><a href="${contextPath}/admin/list_of_hotels">Hotel management</a></p>
						<p><a href="${contextPath}/admin/list_of_reviews">Review management</a></p>
						<p><a href="${contextPath}/admin/list_of_orders">Order management</a></p>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/jsp_elements/_footer.jsp"></jsp:include>
	</div>
</body>
</html>