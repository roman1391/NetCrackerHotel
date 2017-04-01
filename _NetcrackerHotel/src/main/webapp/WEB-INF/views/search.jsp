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
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>

    <title>Search</title>
    <!--<link href="<c:url value="/resources/css/search.css" />" rel="stylesheet">-->
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value ="/resources/jquery-ui-1.12.1.custom/jquery-ui.css" />" rel="stylesheet">
    <link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
          rel="stylesheet">

</head>
<body>
<div class="search">
    <div class="in-search">
        <fieldset class="boxBody">
            <form:form method="post" action="" modelAttribute="searchFilter">
                <form:input path="place" placeholder="Enter country, city or hotel name" />
                <form:input path="startDate" placeholder="check-in" id="startDate" readonly="true" value="${searchFilter.startDate}" />
                <form:input path="endDate" placeholder="check-out" id="endDate" readonly="true" />
                <input type="submit" value="Find" />
            </form:form>
        </fieldset>
    </div>
    <script src="<c:url value="/resources/jquery-ui-1.12.1.custom/jquery.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/jquery-ui-1.12.1.custom/jquery-ui.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/search.js"/>" type="text/javascript"></script>
</div>
<%@include file="../jsp_elements/_footer.jsp"%>
</body>
</html>