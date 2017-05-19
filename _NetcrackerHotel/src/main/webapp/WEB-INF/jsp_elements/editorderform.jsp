<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 13.05.2017
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<form:form style="margin: 20px" action="${contextPath}/change_order"
           method="post" modelAttribute="activeOrder">
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
                    placeholder="check-out" readonly="true"
                    data-validation="required"
                    data-validation-error-msg="Leave date is required."
        />
        <form:errors path="leaveDate" cssClass="ui-state-error-text"/>
    </div>
    <form:input path="id" type="hidden" name="id"
                value="${order.id}"></form:input>
    <form:input path="userId" type="hidden" name="userId"
                value="${order.userId}"></form:input>
    <form:input path="roomId" type="hidden" name="roomId"
                value="${order.roomId}"></form:input>
    <form:input path="username" type="hidden" name="username"
                value="${order.username}"></form:input>
    <form:input path="hotelname" type="hidden" name="hotelname"
                value="${order.hotelname}"></form:input>
    <div class="form-group">
        <form:button type="submit" class="btn btn-primary" >Edit order</form:button>
    </div>
</form:form>
<script src="<c:url value="/resources/jQuery-Form-Validator/form-validator/jquery.form-validator.min.js"/>"
        type="text/javascript"></script>
<script src="<c:url value="/resources/js/validator_property.js"/>"
        type="text/javascript"></script>