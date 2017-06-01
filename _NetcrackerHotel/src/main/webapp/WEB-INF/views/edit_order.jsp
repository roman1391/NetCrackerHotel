<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 13.05.2017
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Order</title>
    <link href="<c:url value ="/resources/jquery-ui-1.12.1.custom/jquery-ui.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/search.css" />" rel="stylesheet">
    <link href="<c:url value="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css"/>" rel="stylesheet"/>
</head>
<body>
<%@include file="../jsp_elements/_header.jsp"%>
<div id="wrapper">
    <script src="<c:url value="/resources/jquery-ui-1.12.1.custom/jquery-ui.js"/>" type="text/javascript"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>
    <c:if test="${error!=null}">
        <div style="margin: 10px" class="alert alert-danger" >
                ${error}
        </div>
    </c:if>
    <div class="content" style="margin-left: 10px">
        <p>Room №: ${order.roomId}</p>
        <p>Username: ${order.username}</p>
        <p>Arrival date: ${order.arrivalDate}</p>
        <p>Leave date: ${order.leaveDate}</p>
        <p>Please enter new Date:</p>
        <%@include file="../jsp_elements/editorderform.jsp"%>
    </div>
</div>
<%@include file="../jsp_elements/_footer.jsp"%>
<script src="<c:url value="/resources/js/search.js"/>" type="text/javascript"></script>
</body>

</html>