<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 4/11/2017
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<form:form style="margin: 20px" action="${path}" method="post" modelAttribute="hotel"
           enctype="multipart/form-data" id="selectPhoto">
    <div class="form-group">
        <input type="file" name="file" accept="image/*">
    </div>
    <div class="form-group">
        <form:label path="name">Hotel name</form:label>
        <form:input path="name" type="text" class="form-control"
                    placeholder="Hotel name" required="required"/>
    </div>
    <div class="form-group">
        <form:label path="country">Country</form:label>
        <form:input path="country" type="text" class="form-control"
                    placeholder="Country" required="required"/>
    </div>
    <div class="form-group">
        <form:label path="city">City</form:label>
        <form:input path="city" type="text" class="form-control"
                    placeholder="City" required="required"/>
    </div>
    <div class="form-group">
        <form:label path="address">Address</form:label>
        <form:input path="address" type="text" class="form-control"
                    placeholder="Address" required="required"/>
    </div>
    <div class="form-group">
        <form:label path="description">Hotel description</form:label>
        <form:input path="description" type="text" class="form-control"
                    placeholder="Hotel description" required="required"/>
    </div>
    <div class="form-group">
        <form:label path="typeOfService">Type of service</form:label>
        <form:select path="typeOfService" required="required">
            <form:option value="1">1</form:option>
            <form:option value="2">2</form:option>
            <form:option value="3">3</form:option>
            <form:option value="4">4</form:option>
            <form:option value="5">5</form:option>
        </form:select>
    </div>
    <div class="form-group">
        <form:button type="submit" class="btn btn-primary">${button}</form:button>
    </div>
</form:form>