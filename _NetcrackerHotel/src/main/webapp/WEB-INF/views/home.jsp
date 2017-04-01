<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title>Home</title>
    <link href="<c:url value="/resources/css/home1.css" />" rel="stylesheet">
	<spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
	<link href="${bootstrap}" rel="stylesheet" />
</head>

<body>
	<div id="wrapper">
		<%@include file="../jsp_elements/_header.jsp"%>
		<a href="<spring:url value="/search/"/>">Search</a>
		<div class="container row">
			<div class="sidebar">
				<div class="in-sidebar">
					<form:form method="POST" modelAttribute="user" action="check-user"
						class="form-signin">
						<fieldset class="boxBody">
							<form:label class="sr-only" path="login">Login:</form:label><br>
							<form:input class="form-control" path="login" />
							<form:errors path="login" cssClass="error" />

							<form:label class="sr-only" path="password">Password:</form:label><br>
							<form:password  class="form-control" path="password" />
							<form:errors path="password" cssClass="error" />
						</fieldset>
						<input type="submit" class="btnLogin" value="Login" tabindex="4">
					</form:form>

					<form:form method="POST" modelAttribute="user" action="reg-user"
						class="registration">
						<input type="submit" class="reg" value="Registration" tabindex="4">
					</form:form>

				</div>
			</div>
			<div class="content">
				<div class="in-content">
					<h1>Hi netcracker!</h1>
					... some information <br />

				</div>
			</div>
		</div>
		<%@include file="../jsp_elements/_footer.jsp"%>
	</div>
</body>
</html>
