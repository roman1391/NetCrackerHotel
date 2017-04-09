<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Home</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />" rel="stylesheet">
</head>

<body>
    <%@include file="../jsp_elements/_header.jsp"%>
	<div id="wrapper">
            <div class="container">
                <div class="row row-offcanvas row-offcanvas-left">
                    Admin page! <br/>
					<a href="j_spring_security_logout">Logout</a>
                    <div class="col-xs-12 col-sm-9">
                        <div class="jumbotron">
                            <h1>Hello Netcrackers</h1>
                            <a href="list_of_users">Get list of users</a>
                        </div>
                    </div>
                </div>
            </div>
		<%@include file="../jsp_elements/_footer.jsp"%>
	</div>
</body>
</html>