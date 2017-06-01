<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Log in</title>
    <link  type ="text/css" href="<c:url value="../../resources/css/loginform.css" />" rel="stylesheet" />
</head>
<body>
<%@include file="../jsp_elements/_header.jsp" %>
<div id="wrapper">

    <div class="container">
        <c:if test="${message!=null}" >
            <div style="margin: 10px" class="alert alert-success" >
                    ${message}
            </div>
        </c:if>
        <%@include file="../jsp_elements/loginform.jsp" %>
    </div>
</div>
<%@include file="../jsp_elements/_footer.jsp"%>
</body>
</html>
