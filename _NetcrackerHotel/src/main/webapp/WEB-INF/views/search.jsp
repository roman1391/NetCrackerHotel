<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 3/31/2017
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <link href="<c:url value="/resources/css/search.css" />" rel="stylesheet">
    <title>Search</title>
    <link href="<c:url value ="/resources/jquery-ui-1.12.1.custom/jquery-ui.css" />" rel="stylesheet">
</head>
<body>
<div class="search">
    <div class="in-search">
        <form class="input">
            <fieldset class="boxBody">
                <p>
                    <input type="search" placeholder="Enter country, city or hotel name" class="city" />
                </p>
                <form action="">
                    <p>
                        <input type="search" placeholder="check-in" id="startDate"  readonly />
                        <input type="search" placeholder="check-out" id="endDate"  readonly />
                    </p>
                </form>
                <input type="submit" value="Find" class="submit" />
            </fieldset>
        </form>
    </div>
</div>
<script src="<c:url value="/resources/jquery-ui-1.12.1.custom/jquery.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/jquery-ui-1.12.1.custom/jquery-ui.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/search.js"/>" type="text/javascript"></script>
</body>
</html>