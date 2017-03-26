<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link href="<c:url value="/resources/css/home1.css" />" rel="stylesheet">
</head>

<body>
	<div id="wrapper">
		<%@include file="../jsp_elements/_header.jsp"%>
		<div class="container row">
			<div class="sidebar">
				<div class="in-sidebar"></div>
			</div>
			<div class="content">
				<div class="in-content">
					<form:form method="POST" modelAttribute="user"
						action="registered-user" class="box registration">
						<fieldset class="boxBody">
							<form:label path="login">Login:</form:label><br>
							<form:input path="login" /><br>
							<form:errors path="login" cssClass="error" /><br>

							<form:label path="password">Password:</form:label><br>
							<form:password path="password" /><br>
							<form:errors path="password" cssClass="error" /><br>
							<form:label path="firstName">First name</form:label><br>
							<form:input path="firstName" /><br>
							<form:errors path="firstName" cssClass="error" /><br>
							<form:label path="lastName">Last name:</form:label><br>
							<form:input path="lastName" /><br>
							<form:errors path="lastName" cssClass="error" /><br>
							<form:label path="email">email:</form:label><br>
							<form:input path="email" /><br>
							<form:errors path="email" cssClass="error" /><br>
						</fieldset>
						<input type="submit" class="reg" value="Registration"
							tabindex="4">
					</form:form>
					<br />

				</div>
			</div>
		</div>
		<%@include file="../jsp_elements/_footer.jsp"%>
	</div>
</body>
</html>