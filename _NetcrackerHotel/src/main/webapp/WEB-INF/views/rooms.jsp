<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 16.05.17
  Time: 4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Available rooms</title>
</head>
<style>
    #rooms{
        font-size: x-large;
        color: #1d1e1f;
        list-style: none;
    }
    #rooms span{
        color: #2a62bc;
    }
</style>
<%@include file="../jsp_elements/_header.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<style>
    .rounded{
        margin-bottom: 10px;
        border-radius: 0.50rem;
        border: solid thin #8f9296;
    }

    a:hover {
        text-decoration: none;
    }
</style>
<body>
<div id="wrapper">
    <div class="container-fluid">
        <div class="container">
            <p><a style="font-size: x-large" href="${contextPath}/hotel_page/${choosenHotel.id}">
                <i class="fa fa-arrow-left" aria-hidden="true"></i> Back to hotel</a></p>
            <c:forEach items="${hotel_rooms}" var="room" varStatus="loop">
            <div style="margin:0 auto" class="row">
                <div class="col-4 rounded">
                    <ul id="rooms">
                        <li class="item">
                            Room №: <span>${room.id}</span>
                        </li>
                        <li class="item">
                            Cost: <span><i class="fa fa-usd" aria-hidden="true"></i>${room.cost}</span>
                        </li>
                        <li class="item">
                            Capacity: <span><i class="fa fa-users" aria-hidden="true"></i> ${room.capacity}</span>
                        </li>
                    </ul>
                    <c:if test="${currentUser.authority.toString() ne 'GUEST' or currentUser.authority.toString() ne 'BLOCKED'}">
                        <div class="form-group">
                            <form:form method="post" id="order" action="${contextPath}/book_page/${room.id}"
                                       modelAttribute="order">
                                <div class="input-group">
                                    <form:input path="userId" type="hidden" name="userId"
                                                value="${currentUser.id}" />
                                    <form:input path="username" type="hidden" name="username"
                                                value="${currentUser.username}" />
                                    <form:input path="roomId" type="hidden" name="roomId"
                                                value="${room.id}" />
                                    <form:input path="hotelname" type="hidden" name="hotelname"
                                                value="${choosenHotel.name}" />
                                                
                                </div>
                                <div style="margin-bottom: 5px" class="btn-group pull-right">
                                    <form:button class="btn btn-success" type="submit">Book</form:button>
                                </div>
                            </form:form>     
                        </div>
                    </c:if>
                </div>
            </div>
            </c:forEach>
        </div>

    </div>
</div>
</body>
<%@include file="../jsp_elements/_footer.jsp"%>
</html>