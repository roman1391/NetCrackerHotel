<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 01.04.17
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link  type ="text/css" href="<c:url value="../../resources/css/loginform.css" />" rel="stylesheet" />

<div class="container col-md-3 id="sidebar">
     <sec:authorize access="!isAuthenticated()">
          <%@include file="loginform.jsp"%>
     </sec:authorize>
</div>