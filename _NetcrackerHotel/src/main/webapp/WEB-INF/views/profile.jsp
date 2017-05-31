<%@ page import="by.netcracker.hotel.entities.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 05.04.2017
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="input" uri="http://cloudinary.com/jsp/taglib" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="<c:url value="../../resources/css/profile.css"/>" />
</head>
<body>
<%
    User curUser = (User) session.getAttribute("currentUser");
%>
<c:set var="edited_user" scope="request" value="${currentUser}"/>
<%@include file="../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <div class="container-fluid">
        <c:if test="${message!=null}">
            <div style="margin: 10px" class="alert alert-success" >
                    ${message}
            </div>
        </c:if>
        <c:if test="${error!=null}">
            <div style="margin: 10px" class="alert alert-danger" >
                    ${error}
            </div>
        </c:if>
      <div style="margin:auto" class="container">
        <form:form id="updateForm" action="update" method="post"  modelAttribute="edited_user"
                   enctype="multipart/form-data" >
        <div class="row" >
            <div class="col-4 form-group">
                <div class="form-group">
                    <label for="loadAvatar" >
                        <img class="img-responsive" src="<c:url value="${currentUser.avatar}"/>">
                    </label>
                    <input disabled="true" class="editable" type="file" name="file" id="loadAvatar" onclick="onFileSelected(event)">
                    <p id="help" style="color: #5cb3fd; font-size: 11pt; display: none;">Click on image to change.</p>
                </div>
            </div>
            <div class="col-3 form-group">
                <sec:authorize access="hasAnyRole('USER','ADMIN')" >
                    <div class="form-group">
                        <form:label path="email" >Email:</form:label>
                        <form:input disabled="true" path="email" id="email" value="${currentUser.email}"
                                    class="editable form-control"/>
                    </div>
                    <div class="form-group">
                        <form:label path="username"  >Username:</form:label>
                        <form:input disabled="true" path="username" id="username" value="${currentUser.username}"
                                    class="editable form-control" />
                    </div>
                </sec:authorize>
                <sec:authorize access="!hasAnyRole('USER','ADMIN')" >
                    <div class="form-group">
                        <form:label path="email" >Email:</form:label>
                        <form:input disabled="true" path="email" id="email" value="${currentUser.email}"
                                    class=" form-control"/>
                    </div>
                    <div class="form-group">
                        <form:label path="username"  >Username:</form:label>
                        <form:input disabled="true" path="username" id="username" value="${currentUser.username}"
                                    class=" form-control" />
                    </div>
                </sec:authorize>
                <div class="form-group">
                    <form:label path="firstName" >First name:</form:label>
                    <form:input disabled="true" path="firstName" id="firstName" value="${currentUser.firstName}"
                                class="editable form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="lastName" >Last name:</form:label>
                    <form:input disabled="true" path="lastName" id="lastName" value="${currentUser.lastName}"
                                class="editable form-control"/>
                </div>
                <div class="form-group">
                    <div class="btn-group pull-right">
                        <form:button id="save-btn" style="display: none" type="submit" class="btn btn-success">Save</form:button>
                        <button type="button" style="margin-left: 5px; display: none" id="cancel-btn" onclick="onCancel()" class="btn btn-danger">Cancel</button>
                    </div>
                </div>
                <div class="btn-group pull-right">
                    <button id ="edit-btn" type="button" style="float: right;" onclick="onEditClick()" class="btn btn-primary">Edit</button>
                    <sec:authorize access="hasAnyRole('USER','ADMIN')" >
                        <a style="margin-left: 5px; float: right;" id ="changePassword" class="btn btn-warning" href="change_password">Change password</a>
                    </sec:authorize>
                </div>
            </div>
        </div>
        </form:form>
       </div>
    </div>
</div>
<%@include file="../jsp_elements/_footer.jsp" %>
</body>
<script>
    var oldValues = {};

    $('#avatar').attr('src', '${currentUser.avatar}');

    function onEditClick() {
        $('input.editable').each(function (index, data) {
                oldValues[index] = data.value;
        });
        $('.editable').attr("disabled", false);
        $('#save-btn').css('display','block');
        $('#cancel-btn').css('display','block');
        $('#edit-btn').css('display', 'none');
        $('#changePassword').css('display','none');
        $('#help').css('display','block');
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
        $('<input />').attr('type', 'hidden')
            .attr('name', "avatar")
            .attr('value', '<%=curUser.getAvatar()%>')
            .appendTo('#updateForm');
        return true;
    });

    function onFileSelected(event) {
        var selectedFile = event.target.files[0];
        var reader = new FileReader();

        var imgtag = document.getElementById("avatar");
        imgtag.title = selectedFile.name;

        reader.onload = function (event) {
            imgtag.src = event.target.result;
            reader.readAsDataURL(selectedFile);
        };
    }

    function onCancel() {
        $('input.editable').each(function (index, data) {
            $(data).val(oldValues[index]);
        });
        $('.editable').attr("disabled", true);
        $('#save-btn').css('display','none');
        $('#cancel-btn').css('display','none');
        $('#edit-btn').css('display', 'block');
        $('#changePassword').css('display','block');
        $('#help').css('display','none');
    }
</script>
</html>
