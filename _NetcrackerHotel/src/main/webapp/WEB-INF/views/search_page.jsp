<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 3/31/2017
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>

    <title>Search</title>
    <link href="<c:url value ="/resources/jquery-ui-1.12.1.custom/jquery-ui.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/search.css" />" rel="stylesheet">
    <link href="<c:url value="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css"/>" rel="stylesheet"/>
</head>
<body>
<%@include file="../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <script src="<c:url value="/resources/jquery-ui-1.12.1.custom/jquery-ui.js"/>" type="text/javascript"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>
    <%@include file="../jsp_elements/searchform.jsp"%>
    <%@include file="../jsp_elements/searchresult.jsp"%>
</div>
<%@include file="../jsp_elements/_footer.jsp" %>
<script src="<c:url value="/resources/js/search.js"/>" type="text/javascript"></script>
</body>
</html>
