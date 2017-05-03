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
<html>
<head>
    <title>Profile</title>
    <style>
        input:not([type]):disabled {
            background: transparent;
            border: none;
        }
    </style>
</head>

<body>
<%
    User curUser = (User) request.getAttribute("currentUser");
%>

<%@include file="../jsp_elements/_header.jsp" %>
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
        <form:form id="updateForm" action="update" method="post" modelAttribute="currentUser"
                   enctype="multipart/form-data" >
        <div class="d-inline-block form-group">
            <img class="img-responsive" src="<c:url value="${currentUser.avatar}"/>">
            <div class="form-group">
                <input type="file" name="file" id="loadAvatar" onclick="onFileSelected(event)">
                <form:input path="avatar" class="form-control" />
            </div>
        </div>
        <div class="d-inline-block form-group">
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
              <sec:authorize access="hasAnyRole('USER','ADMIN')" >
                  <a style="margin-left: 5px" id ="changePassword" class="btn btn-warning" href="/change_password">Change password</a>
              </sec:authorize>
          </div>

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
    }
</script>
</html>
