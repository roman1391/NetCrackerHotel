<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 4/11/2017
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>

<form style="margin: 50px">
    <c:if test="${not empty rooms}">
        <div class="row">
            <c:forEach var="room" items="${rooms}">
                <div class="row list-group-item">
                    <div class="col-12">
                        <p>room capacity - ${room.capacity}</p>
                        <p>room cost - ${room.cost}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</form>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form style="margin: 20px" action="${contextPath}/admin/hotel/${id}/room" method="post" modelAttribute="room">
    <div class="form-group">
        <form:label path="cost">Room cost</form:label>
        <form:input path="cost" type="number" class="form-control"
                    placeholder="Room cost" required="required"/>
    </div>
    <div class="form-group">
        <form:label path="capacity">Room capacity</form:label>
        <form:input path="capacity" type="number" class="form-control"
                    placeholder="Room capacity" required="required"/>
    </div>
    <div class="form-group">
        <form:button type="submit" class="btn btn-primary">Add room</form:button>
    </div>
</form:form>