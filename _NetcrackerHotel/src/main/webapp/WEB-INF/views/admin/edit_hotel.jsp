<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Edit hotel</title>
</head>
<body>
<%@include file="../../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <c:set var="path" value="${contextPath}/admin/hotel/${id}/edit"/>
    <c:set var="button" value="Edit hotel"/>
    <%@include file="../../jsp_elements/hotel_form.jsp"%>
    <a  class = "btn btn-primary" style="margin: 20px" href="${contextPath}/admin/hotel_page/${id}">Hotel page</a>
</div>
<%@include file="../../jsp_elements/_footer.jsp" %>
</body>
</html>
