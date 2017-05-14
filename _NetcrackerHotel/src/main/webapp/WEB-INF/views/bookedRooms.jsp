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
</head>
<c:set var="user" scope="request" value="${currentUser}"/>
<body>
<%@include file="../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <div class="container">
        <div class="row row-offcanvas row-offcanvas-left">
            <div class="col-xs-12 col-sm-9">
                <div class="jumbotron">
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
                    <table>
                        <tbody>
                        <c:forEach items="${orders}" var="order" varStatus="loop">
                            <tr>

                                <br>Order Id: ${order.id}
                                <form:form method="post" id="user" action="${contextPath}/delete_order/${order.id}"
                                           modelAttribute="user" >
                                    <form:input path="id" type="hidden" name="orderId"
                                                value="${currentUser.id}"></form:input>
                                    <form:button type="submit" id="edit-btn" class="btn btn-danger">Delete order</form:button>
                                </form:form>

                                <div class="btn-group">
                                    <button style="margin: 0 15px 0 15px" id="edit-btn"
                                            onclick="location.href='/edit_order/${order.id}'"
                                            class="btn btn-primary">Edit
                                    </button>
                                </div>

                                <br>Room Id: ${order.roomId}
                                <br>User Id: ${order.userId}
                                <br>First Name: ${order.firstName }
                                <br>Last Name: ${order.lastName }
                                <br>Arrival Date: ${order.arrivalDate}
                                <br>Leave Date: ${order.leaveDate}
                                <br>Pay Value: ${order.payValue}
                                <br>Is Paid: ${order.isPaid()}

                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../jsp_elements/_footer.jsp" %>
</div>
<script src="<c:url value="/resources/js/search.js"/>" type="text/javascript"></script>
</body>
</html>