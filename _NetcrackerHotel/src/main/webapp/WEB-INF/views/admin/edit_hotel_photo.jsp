<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Photo & description</title>
</head>
<body>
<%@include file="../../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <c:set var="path" value="${contextPath}/admin/hotel/${id}/edit/photo"/>
    <c:set var="button" value="Add photos"/>
    <c:set var="pathDelete" value="${contextPath}/admin/hotel/${id}/edit/delete/photo"/>
    <%@include file="../../jsp_elements/hotelMin.jsp" %>
    <%@include file="../../jsp_elements/photo_form.jsp" %>
    <a  class = "btn btn-primary" style="margin: 20px" href="${contextPath}/admin/hotel_page/${id}">Hotel page</a>
</div>
<%@include file="../../jsp_elements/_footer.jsp" %>
</body>
</html>
