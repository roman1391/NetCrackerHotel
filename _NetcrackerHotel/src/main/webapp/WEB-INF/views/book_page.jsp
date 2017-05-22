<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 25.04.2017
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Hotel page</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link
            href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
            rel="stylesheet">
    <script type="text/javascript">
        function calcAmount(payValue, startDate, endDate) {
            var difference = endDate - startDate;
            document.write((difference * payValue) / (24 * 60 * 60 * 1000));
        }
    </script>
</head>

<body>
<%@include file="../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <div class="container">
        <div class="row row-offcanvas row-offcanvas-left">
            <div class="col-xs-12 col-sm-9">
                <div class="jumbotron">
                    <h3>Order page</h3>
                    <c:choose>
                        <c:when test="${message eq null}">
                            <div style="margin: 50px" class="alert alert-success">
                                The booking was successful
                            </div>
                            Room №: ${order.roomId }<br>
                            First Name: ${order.firstName }<br>
                            Last Name: ${order.lastName }<br>
                            Arrival Date: ${order.arrivalDate }<br>
                            Leave Date: ${order.leaveDate }<br>
                            Total amount: <script>calcAmount(${order.payValue}, ${order.arrivalDate.getTime()}, ${order.leaveDate.getTime()})</script><br>
                        </c:when>
                        <c:otherwise>
                            <div style="margin: 10px" class="alert alert-danger">
                                This time is not available for booking
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../jsp_elements/_footer.jsp" %>
</div>
</body>
</html>