<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 01.04.17
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>About</title>
    <link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
          rel="stylesheet">
</head>
<body>
   <%@include file="../jsp_elements/_header.jsp"%>
     <h1 style="margin-left: auto">About project</h1>
     <div>
         <p style="font-size: large">Netcracker project</p>
     </div>
   <%@include file="../jsp_elements/_footer.jsp"%>
</body>
</html>
