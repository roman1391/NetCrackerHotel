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
					<c:if test="${success!=null}">
						<div style="margin: 10px;width:300px;" class="alert alert-success">${success}</div>
					</c:if>
						<h3>Admin page</h3>
						<p><a href="${contextPath}/admin/list_of_users">Users management</a></p>
						<p><a href="${contextPath}/admin/list_of_hotels">Hotels management</a></p>
						<p><a href="${contextPath}/admin/list_of_reviews">Reviews management</a></p>
						<p><a href="${contextPath}/admin/list_of_orders">Orders management</a></p>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/jsp_elements/_footer.jsp"></jsp:include>
	</div>
</body>
</html>