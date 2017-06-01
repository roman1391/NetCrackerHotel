<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 01.05.2017
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
          rel="stylesheet">
    <link href="<c:url value="/resources/jQuery-Form-Validator/form-validator/theme-default.min.css"/>"
          rel="stylesheet" type="text/css" />
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
        <div style="margin: 50px" class="alert alert-danger" >
                ${error}
        </div>
    </c:if>
    <div class="row">
        <div style="margin: auto" class="col-8">
            <h1>Please enter additional information</h1>
            <div class="row">
                <div class="col-4">
                    <p>Room №: ${roomId}</p>
                    <p>Username: ${currentUser.username}</p>
                </div>
                <div class="col-4">
                    <p>Arrival date: ${searchFilter.startDate}</p>
                    <p>Leave date: ${searchFilter.endDate}</p>
                </div>
            </div>
            <%@include file="../jsp_elements/addorderform.jsp"%>
        </div>
    </div>
    <%@include file="../jsp_elements/_footer.jsp"%>
</div>
<script src="<c:url value="/resources/jQuery-Form-Validator/form-validator/jquery.form-validator.min.js"/>"
        type="text/javascript"></script>
<script src="<c:url value="/resources/js/validator_property.js"/>"
        type="text/javascript"></script>
<script src="<c:url value="/resources/js/search.js"/>" type="text/javascript"></script>
</body>
</html>