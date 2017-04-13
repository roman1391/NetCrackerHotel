<%@ page import="org.codehaus.jackson.map.ObjectMapper" %>
<%--
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
    ObjectMapper mapper = new ObjectMapper();
%>

<%@include file="../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <button onclick="onEditClick()" class="edit-btn">Edit</button>
    <div>
        <input id="email" value="${currentUser.email}"
               class="editable">
        <input id="accessLevel" value="${currentUser.accessLevel}"
               class="editable">
        <input id="firstName" value="${currentUser.firstName}"
               class="editable">
        <input id="lastName" value="${currentUser.lastName}"
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
        userDTO.id = ${currentUser.id};
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
