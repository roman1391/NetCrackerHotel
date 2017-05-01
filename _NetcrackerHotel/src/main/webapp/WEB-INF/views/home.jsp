<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<title>Home</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link
	href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
	rel="stylesheet">
</head>
<body>
	<%@include file="../jsp_elements/_header.jsp"%>
	<div id="wrapper">
		<div class="container">
			<div class="row row-offcanvas row-offcanvas-left">
				<div class="col-xs-12 col-sm-9">
					<div class="jumbotron">
					<sec:authorize access="hasRole('ADMIN')">
						<div style="margin: 50px" class="alert alert-danger">
							Profile was blocked!</div>
					</sec:authorize>
						<h1>Hello Netcrackers</h1>
					<sec:authorize access="isAuthenticated()">
						<h3>Current user - <sec:authentication property="principal.username"/> </h3><br>
					</sec:authorize>
					<sec:authorize access="!isAuthenticated()">
						<h3>Current user - ${currentUser.username } </h3><br>
					</sec:authorize>
					login admin <br> password 123 <br> login user <br>
					password 1234 <br>
					</div>
				</div>
			</div>
		</div>
		<%@include file="../jsp_elements/_footer.jsp"%>
	</div>
</body>
</html>
