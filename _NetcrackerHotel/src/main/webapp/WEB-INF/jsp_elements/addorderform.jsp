<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 01.05.2017
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<form:form id="registrationForm" style="margin: 20px" action="${contextPath}/book_complete"
           method="post" modelAttribute="order">
    <c:if test="${searchFilter.startDate eq '' or searchFilter.endDate eq ''}">
        <div class="form-group">
            <form:label path="arrivalDate">Arrival date</form:label>
            <form:input path="arrivalDate" type="text" class="form-control" id="startDate"
                        placeholder="check-in" readonly="true"
                        data-validation="required"
                        data-validation-error-msg="Arrival date is required."
            />
            <form:errors path="arrivalDate" cssClass="ui-state-error-text"/>
        </div>
        <div class="form-group">
            <form:label path="leaveDate">Leave date</form:label>
            <form:input path="leaveDate" type="text" class="form-control" id="endDate"
                        placeholder="check-out"
                        data-validation="required"
                        data-validation-error-msg="Leave date is required."
                        readonly="true"
            />
            <form:errors path="leaveDate" cssClass="ui-state-error-text"/>
        </div>
    </c:if>
    <div class="form-group">
        <form:label path="firstName">First name</form:label>
        <form:input path="firstName" type="text" class="form-control"
                    placeholder="First name" required="required"
                    data-validation="length alphanumeric"
                    data-validation-length="6-15"
                    data-validation-error-msg="First name has to be an alphanumeric value (6-15 chars)"
        />
        <form:errors path="firstName" cssClass="ui-state-error-text"/>
    </div>
    <div class="form-group">
        <form:label path="lastName">Last name</form:label>
        <form:input path="lastName" type="text" class="form-control"
                    placeholder="Last name" required="required"
                    data-validation="length alphanumeric"
                    data-validation-length="5-15"
                    data-validation-error-msg="Last name has to be an alphanumeric value (5-15 chars)"
        />
        <form:errors path="lastName" cssClass="ui-state-error-text"/>
    </div>
    <form:input path="userId" type="hidden" name="userId"
                value="${currentUser.id}"></form:input>
    <form:input path="roomId" type="hidden" name="roomId"
                value="${order.roomId}"></form:input>
    <form:input path="username" type="hidden" name="username"
                value="${order.username}"></form:input>
    <form:input path="hotelname" type="hidden" name="hotelname"
                value="${order.hotelname}"></form:input>
    <form:input path="payValue" type="hidden" name="payValue"
                value="${order.payValue}"></form:input>
    <div class="form-group">
        <form:button type="submit" class="btn btn-primary">Add new order</form:button>
    </div>
</form:form>