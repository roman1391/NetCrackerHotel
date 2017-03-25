<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Home</title>
<link href="<c:url value="/resources/css/home1.css" />" rel="stylesheet">

</head>

<body>
	<div id="wrapper">
		<%@include file="../jsp_elements/_header.jsp"%>
		<div class="container row">
			<div class="sidebar">
				<div class="in-sidebar">
					<form:form method="POST" modelAttribute="user" action="check-user"
						class="box login">
						<fieldset class="boxBody">
							<form:label path="login">Login:</form:label>
							<form:input path="login" />
							<form:errors path="login" cssClass="error" />

							<form:label path="password">Password:</form:label>
							<form:password path="password" />
							<form:errors path="password" cssClass="error" />
						</fieldset>
						<input type="submit" class="btnLogin" value="Login" tabindex="4"> 
					</form:form>

					<div class="registration">
						<form name="RegForm" action="controller" method="POST">
							<input type="hidden" name="command" value="send" /> <input
								type="hidden" name="ref" value="path.page.reg" /> <input
								type="submit" name="button" value="Registration" />
						</form>
					</div>
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
