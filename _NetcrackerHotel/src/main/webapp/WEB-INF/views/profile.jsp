<%@ page import="by.netcracker.hotel.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 05.04.2017
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <script src="<c:url value="/resources/jquery-ui-1.12.1.custom/jquery.js"/>" type="text/javascript"></script>
    <style>
        input, .save {
            float: left;
            clear: left;
            margin: 20px;
        }
    </style>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />" rel="stylesheet">
</head>

<body>
<%@include file="../jsp_elements/navbar.jsp"%>


<%
    User user = User.getUser();
%>
<div id ="wrapper">
  <button onclick="onEditClick()">Edit</button>
    <div class="form-group">
       <input id="email" value="<%=user.getEmail()%>"
           class="editable form-control">
       <input id="accessLevel" value="<%=user.getAccessLevel()%>"
           class="editable form-control">
       <input id="firstName" value="<%=user.getFirstName()%>"
           class="editable form-control">
       <input id="lastName" value="<%=user.getLastName()%>"
           class="editable form-control">
    </div>
    <button onclick="onSave()" class="save">Save</button>



    </div>
</body>
<%@include file="../jsp_elements/_footer.jsp"%>
<script>
    var isEditable = true;
    function onEditClick() {
        isEditable = !isEditable;
        $('.editable').attr("disabled", !isEditable);
        $('.save').css('display', isEditable ? 'block' : 'none');
    }

    function onSave() {
        var userDTO = {};
        userDTO.id = <%=user.getId()%>
        $('input.editable').each(function (index, data) {
            userDTO[data.id] = data.value;
        });
        $.ajax({
            url: "save",
            method: "POST",
            data: userDTO
        }).done(function (msg) {
            alert("Data Saved: " + msg);
        });
    }
    onEditClick();
</script>

</html>
