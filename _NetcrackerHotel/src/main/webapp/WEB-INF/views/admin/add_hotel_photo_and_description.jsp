<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 4/15/2017
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <c:set var="path" value="${contextPath}/admin/hotel/${id}/photo"/>
    <c:set var="pathDelete" value="${contextPath}/admin/hotel/${id}/photo/delete"/>
    <c:set var="button" value="Add photos"/>
    <%@include file="../../jsp_elements/hotelMin.jsp" %>
    <%@include file="../../jsp_elements/photo_form.jsp" %>
    <form style="margin: 20px">
        <div class="form-group">
            <input class="btn btn-primary" type="button" onclick="location.href='${contextPath}/admin/hotel/${id}/room'" value="Add rooms"/>
        </div>
    </form>
</div>
<%@include file="../../jsp_elements/_footer.jsp" %>
</body>
</html>
