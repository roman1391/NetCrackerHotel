<%@ page import="by.netcracker.hotel.entities.User" %>
<%@ page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>User page</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link
	href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
	rel="stylesheet">

</head>

<body>
<%
    User curUser = (User) request.getAttribute("user");
%>

<%@include file="../../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <div class="jumbotron">
        <c:if test="${message!=null}">
            <div style="margin: 50px" class="alert alert-success" >
                    ${message}
            </div>
        </c:if>
        <c:if test="${error!=null}">
            <div style="margin: 50px" class="alert alert-danger" >
                    ${error}
            </div>
        </c:if>
      <div class="content">
      		<h3>User editing:</h3>
            <img class="img-responsive" src="<c:url value="${user.avatar}"/>">

        <form:form id="updateForm" action="update" method="post" modelAttribute="user"
                   enctype="multipart/form-data" >
        <div class="d-inline-block form-group">
            <sec:authorize access="hasAnyRole('USER','ADMIN')" >
                <div class="form-group">
                  <form:label path="email" >Email:</form:label>
                  <form:input disabled="true" path="email" id="email" value="${user.email}"
                             class="editable form-control"/>
                </div>
                <div class="form-group">
                  <form:label path="username"  >Username:</form:label>
                  <form:input disabled="true" path="username" id="username" value="${user.username}"
                            class="editable form-control" />
                </div>
            </sec:authorize>
            <div class="form-group">
                <form:label path="firstName" >First name:</form:label>
                <form:input disabled="true" path="firstName" id="firstName" value="${user.firstName}"
                            class="editable form-control"/>
            </div>
            <div class="form-group">
                <form:label path="lastName" >Last name:</form:label>
                <form:input disabled="true" path="lastName" id="lastName" value="${user.lastName}"
                            class="editable form-control"/>
            </div>
            <c:choose>
            	<c:when test="${currentUser.username eq user.username }">
            	<div class="form-group">
                <form:label path="authority" >Authority:</form:label>
				<form:select disabled="true" path="authority" id="authority" class="form-control">
                    <form:option value="ADMIN" label="Admin"/>
                    <form:option value="USER" label="User"/>
                    <form:option value="BLOCKED" label="Blocked"/>
                </form:select>
            	</div>
            	<div class="form-group">
                <form:label path="enabled" >State:</form:label>
				<form:select disabled="true" path="enabled" id="enabled" class="form-control" >
                    <form:option value="true" label="Enabled"/>
                    <form:option value="false" label="Deactivated"/>
                </form:select>
            	</div>
            	</c:when>
            	<c:when test="${currentUser.username ne user.username }">
            	<div class="form-group">
                <form:label path="authority" >Authority:</form:label>
				<form:select disabled="true" path="authority" id="authority" class="editable form-control">
                    <form:option value="ADMIN" label="Admin"/>
                    <form:option value="USER" label="User"/>
                    <form:option value="BLOCKED" label="Blocked"/>
                </form:select>
            	</div>
            	<div class="form-group">
                <form:label path="enabled" >State:</form:label>
				<form:select disabled="true" path="enabled" id="enabled" class="editable form-control">
                    <form:option value="true" label="Enabled"/>
                    <form:option value="false" label="Deactivated"/>
                </form:select>
           		 </div>
            	</c:when>
            </c:choose>
            
        </div>
            <div class="form-group">
                <div class="btn-group">
                    <form:button id="save-btn" style="display: none" type="submit" class="btn btn-success">Save</form:button>
                    <button style="margin-left: 5px; display: none" id="cancel-btn" onclick="onCancel()" class="btn btn-danger">Cancel</button>
                </div>
            </div>

        </form:form>
          
          <div class="btn-group">
              <button id ="edit-btn" onclick="onEditClick()" class="btn btn-primary">Edit</button>
              
<!--               <a style="margin-left: 5px" id ="changePassword" class="btn btn-warning" href="change_password">Change password</a> -->

          </div>

       </div>
    </div>
</div>
<%@include file="../../jsp_elements/_footer.jsp" %>
</body>
<script>
    var oldValues = {};

    $('#avatar').attr('src', '${user.avatar}');

    function onEditClick() {
        $('input.editable').each(function (index, data) {
                oldValues[index] = data.value;
        });
        $('.editable').attr("disabled", false);
        $('#save-btn').css('display','block');
        $('#cancel-btn').css('display','block');
        $('#edit-btn').css('display', 'none');
        $('#changePassword').css('display','none');
    }

    $("#updateForm").submit(function (eventObj) {
        var userId = '<%=curUser.getId()%>';
        $('<input />').attr('type', 'hidden')
            .attr('name', "id")
            .attr('value', userId)
            .appendTo('#updateForm');
        $('<input />').attr('type', 'hidden')
            .attr('name', "authority")
            .attr('value', '<%=curUser.getAuthority().toString()%>')
            .appendTo('#updateForm');
        $('<input />').attr('type', 'hidden')
            .attr('name', "enabled")
            .attr('value', 'true')
            .appendTo('#updateForm');
        return true;
    });

    function onCancel() {
        $('input.editable').each(function (index, data) {
            $(data).val(oldValues[index]);
        });
        onEditClick();
    }
</script>

</html>