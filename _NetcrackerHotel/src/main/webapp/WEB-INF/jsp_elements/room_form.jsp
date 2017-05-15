<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 4/11/2017
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>


<c:if test="${not empty rooms}">
    <form style="margin: 20px;" action="${pathDelete}" method="post" enctype="multipart/form-data">
        <div class="row">
            <input type="checkbox" name="roomsToDelete" value="-1" checked="checked" style="opacity:0;
            position:absolute; left:9999px;"/>
            <c:forEach var="room" items="${rooms}">
                <label style=" border: 1px solid #003eff; padding: 10px;">
                    <input type="checkbox" name="roomsToDelete" value="${room.id}"/>
                    <p>room capacity - ${room.capacity}</p>
                    <p>room cost - ${room.cost}</p>
                </label>
            </c:forEach>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Delete rooms</button>
        </div>
    </form>
</c:if>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form style="margin: 20px" action="${path}" method="post" modelAttribute="room">
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
        <form:button type="submit" class="btn btn-primary">${button}</form:button>
    </div>
</form:form>