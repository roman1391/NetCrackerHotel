<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Leave a review</title>
    <link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
          rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css" />"
          rel="stylesheet" />
</head>
<body>
<%@include file="../jsp_elements/_header.jsp"%>
<div id="wrapper">
    <div class="content">
        <%@include file="../jsp_elements/reviewform.jsp"%>
    </div>
    <%@include file="../jsp_elements/_footer.jsp"%>
</div>
<%@include file="../jsp_elements/_footer.jsp"%>
</body>
</html>
