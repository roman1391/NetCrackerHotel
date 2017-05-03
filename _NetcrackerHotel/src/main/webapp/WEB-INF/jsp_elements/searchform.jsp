<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form style="margin: 50px" method="post" action="find-hotels" modelAttribute="searchFilter">
    <div class="form-group">
        <form:label path="place">Enter country, city or hotel name:</form:label>
        <form:select path="place" class="form-control" id="selectPlace" multiple="multiple">
            <c:forEach var="place" items="${search}">
            <form:option selected="selected"  value="${place}"/>
            </c:forEach>
            <form:options items="${places}" />
        </form:select>
    </div>
    <div class="form-group">
        <form:label path="startDate">Start date</form:label>
        <form:input class="form-control" path="startDate" placeholder="check-in" id="startDate" readonly="true"/>
        <form:label path="endDate">End date </form:label>
        <form:input class="form-control" path="endDate" placeholder="check-out" id="endDate" readonly="true"/>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Search</button>
    </div>
</form:form>