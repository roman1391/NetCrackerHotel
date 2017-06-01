<%@ page import="by.netcracker.hotel.entities.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 26.04.2017
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Booked rooms</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link
            href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
            rel="stylesheet">
    <link href="<c:url value ="/resources/jquery-ui-1.12.1.custom/jquery-ui.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/search.css" />" rel="stylesheet">
    <link href="<c:url value="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css"/>"
          rel="stylesheet"/>
    <script type="text/javascript">
        function calcAmount(payValue, startDate, endDate) {
            var difference = endDate - startDate;
            document.write((difference * payValue) / (24 * 60 * 60 * 1000));
        }
    </script>
    <style>
        .rounded{
            background: #F7F6ED;
            margin: 10px;
            border-radius: 10px ;
        }
        .rounded ul{
            font-size: x-large;
            color: #1d1e1f;
            list-style: none;
        }
        .rounded ul span{
            color: #2a62bc;
        }
    </style>
</head>
<c:set var="user" scope="request" value="${currentUser}"/>
<%@include file="../jsp_elements/_header.jsp" %>
<body>
<div id="wrapper">
    <div class="container-flued">
        <div class="row">
            <div style="margin: 0 auto" class="col-9">
                <div class="wrap">
                    <script src="<c:url value="/resources/jquery-ui-1.12.1.custom/jquery-ui.js"/>"
                            type="text/javascript"></script>
                    <script src="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>
                    <h3>Booked rooms</h3>
                    <c:choose>
                        <c:when test="${message eq 'error'}">
                            <div style="margin: 10px" class="alert alert-danger">
                                This time is not available for booking
                            </div>
                        </c:when>
                        <c:when test="${message eq 'success'}">
                            <div style="margin: 10px" class="alert alert-success">
                                Booking changed successfully
                            </div>
                        </c:when>
                    </c:choose>
                    <c:forEach items="${orders}" var="order" varStatus="loop" >
                         <div class="rounded">
                            <div class="row">
                                <div class="col-3">
                                    <ul class="order">
                                        <li class="active">
                                            Order №: <span>${order.id}</span>
                                        </li>
                                        <li class="active">
                                            Hotel name: <span>${order.hotelname}</span>
                                        </li>
                                        <li class="active">
                                            Room №": <span>${order.roomId}</span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-3">
                                    <ul class="order">
                                        <li class="active">
                                            First Name: <span>${order.firstName}</span>
                                        </li>
                                        <li class="active">
                                            Last Name: <span>${order.lastName}</span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-3">
                                    <ul class="order">
                                        <li class="active">
                                            Arrival Date: <span>${order.arrivalDate}</span>
                                        </li>
                                        <li class="active">
                                            Leave Date: <span>${order.leaveDate}</span>
                                        </li>
                                        <li class="active">
                                            Total amount: <span><script>calcAmount(${order.payValue}, ${order.arrivalDate.getTime()}, ${order.leaveDate.getTime()})</script></span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-3">
                                    <div style="margin-top: 5px; margin-right: 5px"
                                         class="btn-group pull-right">
                                        <div style="margin-left:15px" class="d-inline-block">
                                            <button style="margin: 0 15px 0 15px" id="edit-btn"
                                                    onclick="location.href='edit_order/${order.id}'"
                                                        class="btn btn-primary"><i class="fa fa-cog" aria-hidden="true"></i>
                                            </button>
                                        </div>
                                        <form:form method="post" id="user" action="${contextPath}/delete_order/${order.id}"
                                                   modelAttribute="user" >
                                            <form:input path="id" type="hidden" name="orderId"
                                                        value="${currentUser.id}" />
                                            <form:button type="submit" id="edit-btn" class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i></form:button>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                         </div>
                        </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/resources/js/search.js"/>" type="text/javascript"></script>
</body>
<%@include file="../jsp_elements/_footer.jsp" %>
</html>