<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
          rel="stylesheet">
    <link href="<c:url value="/resources/jQuery-Form-Validator/theme-default.min.css"/>"
          rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="../jsp_elements/_header.jsp"%>
	<div id="wrapper">
			<div class="content">
				<%@include file="../jsp_elements/registrationform.jsp"%>
			</div>
		<%@include file="../jsp_elements/_footer.jsp"%>
	</div>
    <script src="<c:url value="/resources/jquery-ui-1.12.1.custom/jquery.js"/>"
            type="text/javascript"></script>
    <script src="<c:url value="/resources/jQuery-Form-Validator/jquery.form-validator.min.js"/>"
            type="text/javascript"></script>
    <script src="<c:url value="/resources/js/registration_form_validation.js"/>"
            type="text/javascript"></script>
</body>
</html>