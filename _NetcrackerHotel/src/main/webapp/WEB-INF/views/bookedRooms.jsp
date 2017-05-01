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
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Hotel page</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link
            href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
            rel="stylesheet">
</head>

<body>
<%@include file="../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <div class="container">
        <div class="row row-offcanvas row-offcanvas-left">
            <div class="col-xs-12 col-sm-9">
                <div class="jumbotron">
                    <h3>Booked rooms</h3>
                    <table>
                        <tbody>
                        <c:forEach items="${orders}" var="order">
                            <tr>
                                <br>Order Id: ${order.id}
                                <br>Room Id: ${order.roomId}
                                <br>User Id: ${order.userId}
                                <br>First Name: ${order.firstName }
                                <br>Last Name: ${order.lastName }
                                <br>Arrival Date: ${order.arrivalDate}
                                <br>Leave Date: ${order.leaveDate}
                                <br>Pay Value: ${order.payValue}
                                <br>Is Paid: ${order.isPaid()}
                                <br>
                                <c:if test="${currentUser.authority.toString() ne 'GUEST'}"></c:if>
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
</body>
</html>