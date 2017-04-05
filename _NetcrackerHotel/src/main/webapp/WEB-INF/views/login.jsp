<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>

<body>

	<c:if test="${not empty error}">
		${error}
	</c:if>
	<form name='form_login' action="j_spring_security_check" method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='user_login' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password_login' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>



</body>
</html>