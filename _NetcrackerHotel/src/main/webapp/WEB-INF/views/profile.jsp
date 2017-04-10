<%@ page import="by.netcracker.hotel.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 05.04.2017
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Profile</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <style>
        input, .save-btn, .cancel-btn, .edit-btn {
            float: left;
            clear: left;
            margin: 20px;
        }

        input:not([type]):disabled {
            background: transparent;
            border: none;
        }
    </style>
</head>

<body>

<%
    User user = (User) request.getAttribute("user");
%>

<%@include file="../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <button onclick="onEditClick()" class="edit-btn">Edit</button>
    <div>
        <input id="email" value="<%=user.getEmail()%>"
               class="editable">
        <input id="accessLevel" value="<%=user.getAccessLevel()%>"
               class="editable">
        <input id="firstName" value="<%=user.getFirstName()%>"
               class="editable">
        <input id="lastName" value="<%=user.getLastName()%>"
               class="editable">
    </div>
    <button onclick="onSave()" class="save-btn">Save</button>
    <button onclick="onCancel()" class="cancel-btn">Cancel</button>
    <%@include file="../jsp_elements/_footer.jsp" %>
</div>
</body>
<script>
    var isEditable = true;
    var oldValues = {};
    function onEditClick() {
        isEditable = !isEditable;
        if (isEditable) {
            $('input.editable').each(function (index, data) {
                oldValues[index] = data.value;
            });
        }
        $('.editable').attr("disabled", !isEditable);
        $('.save-btn').css('display', isEditable ? 'block' : 'none');
        $('.cancel-btn').css('display', isEditable ? 'block' : 'none');
        $('.edit-btn').css('display', !isEditable ? 'block' : 'none');
    }

    function onSave() {
        var userDTO = {};
        userDTO.id = <%=user.getId()%>
            $('input.editable').each(function (index, data) {
                userDTO[data.id] = data.value;
            });
        $.ajax({
            url: "update",
            method: "POST",
            data: userDTO
        }).done(function (msg) {
            console.log(msg);
            onEditClick();
        });
    }

    function onCancel() {
        $('input.editable').each(function (index, data) {
            $(data).val(oldValues[index]);
        });
        onEditClick();
    }
    onEditClick();
</script>

</html>
