<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Leave review</title>
    <link href="<c:url value="/resources/jQuery-Form-Validator/form-validator/theme-default.min.css"/>"
          rel="stylesheet" type="text/css" />
</head>

<%@include file="../jsp_elements/_header.jsp" %>
<body>
<div id="wrapper">
    <div class="row">
            <div style="margin: 0 auto" class="col-8">
                <h3 style="margin: auto; color: #2b2b2b">Review page</h3>
                <form:form method="post" id="review" action="${choosenHotel.id}" modelAttribute="review" >
                        <div class="form-group">
                            <form:label path="rating">Your rating:</form:label>
                            <form:select path="rating" class="form-control" >
                                <form:option value="${1}" label="1"/>
                                <form:option value="${2}" label="2"/>
                                <form:option value="${3}" label="3"/>
                                <form:option value="${4}" label="4"/>
                                <form:option value="${5}" label="5"/>
                                <form:option value="${6}" label="6"/>
                                <form:option value="${7}" label="7"/>
                                <form:option value="${8}" label="8"/>
                                <form:option value="${9}" label="9"/>
                                <form:option value="${10}" label="10"/>
                            </form:select>
                        </div>
                        <div class="form-group">
                            <form:label path="text">Review text:</form:label>
                            <form:textarea path="text" type="text" name="text"
                                           class="form-control" rows="5"
                                           data-validation="length"
                                           data-validation-length="20-2000"
                                           data-validation-error-msg="Review have to be length from 20 to 2000"/>
                            <form:input path="userId" type="hidden" name="userId" value="${currentUser.id}"></form:input>
                            <form:input path="username" type="hidden" name="username" value="${currentUser.username}"></form:input>
                            <form:input path="hotelId" type="hidden" name="hotelId" value="${choosenHotel.id}"></form:input>
                            <form:input path="hotelname" type="hidden" name="hotelname" value="${choosenHotel.name}"></form:input>
                        </div>
                        <div class="btn-group pull-right">
                            <form:button class="btn btn-primary" type="submit">Send review</form:button>
                        </div>
					</form:form>
            </div>
    </div>
</div>
</body>
<%@include file="../jsp_elements/_footer.jsp" %>
</html>
<script src="<c:url value="/resources/jQuery-Form-Validator/form-validator/jquery.form-validator.min.js"/>"
        type="text/javascript"></script>
<script src="<c:url value="/resources/js/validator_property.js"/>"
        type="text/javascript"></script>