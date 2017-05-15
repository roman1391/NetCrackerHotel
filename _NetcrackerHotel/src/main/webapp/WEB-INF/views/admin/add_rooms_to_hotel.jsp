<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 4/24/2017
  Time: 6:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Rooms</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
          rel="stylesheet">
    <link href="<c:url value="/resources/jQuery-Form-Validator/form-validator/theme-default.min.css"/>"
          rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="../../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <c:set var="path" value="${contextPath}/admin/hotel/${id}/room"/>
    <c:set var="button" value="Add room"/>
    <c:set var="pathDelete" value="${contextPath}/admin/hotel/${id}/room/delete"/>
    <%@include file="../../jsp_elements/hotelMin.jsp" %>
    <%@include file="../../jsp_elements/room_form.jsp" %>
    <a  class = "btn btn-primary" style="margin: 20px" href="${contextPath}/admin/hotel_page/${id}">Hotel page</a>
</div>
<%@include file="../../jsp_elements/_footer.jsp" %>
<script src="<c:url value="/resources/jquery-ui-1.12.1.custom/jquery.js"/>"
        type="text/javascript"></script>
<script src="<c:url value="/resources/jQuery-Form-Validator/form-validator/jquery.form-validator.min.js"/>"
        type="text/javascript"></script>
</body>
</html>
