<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/home1.css" />" rel="stylesheet">
</head>

<body>
	<div id="wrapper">
		<%@include file="../jsp_elements/_header.jsp"%>
		<div class="container row">
			<div class="sidebar">
				<div class="in-sidebar">
					<p>Hello ${user.login}</p>
					<p>Password is ${user.password}</p>
					<p>First name is ${user.firstName}</p>
					<p>Last name is ${user.lastName}</p>
					<p>email is ${user.email}</p>
				</div>
			</div>
			<div class="content">
				<div class="in-content">
					...some information
				</div>
			</div>
		</div>
		<%@include file="../jsp_elements/_footer.jsp"%>
	</div>
</body>
</html>