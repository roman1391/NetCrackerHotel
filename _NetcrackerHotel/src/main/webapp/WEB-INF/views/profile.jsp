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
<html>
<head>
    <title>Profile</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <style>
        img {
            width: 100px;

        }

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
    User curUser = (User) request.getAttribute("currentUser");
%>

<%@include file="../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <button onclick="onEditClick()" class="edit-btn">Edit</button>
    <img src="" id="avatar">
    <form:form id="updateForm" action="update" method="post" modelAttribute="activeUser"
               enctype="multipart/form-data">
        <div class="form-group">
            <input type="file" name="file" id="loadAvatar" onclick="onFileSelected(event)">
            <form:input path="avatar"/>
            <form:input path="email" id="email" value="${currentUser.email}"
                        class="editable"/>
            <form:input path="accessLevel" id="accessLevel" value="${currentUser.accessLevel}"
                        class="editable"/>
            <form:input path="firstName" id="firstName" value="${currentUser.firstName}"
                        class="editable"/>
            <form:input path="lastName" id="lastName" value="${currentUser.lastName}"
                        class="editable"/>
        </div>
        <form:button type="submit" class="save-btn">Save</form:button>
        <button onclick="onCancel()" class="cancel-btn">Cancel</button>
    </form:form>
    <%@include file="../jsp_elements/_footer.jsp" %>
</div>
</body>
<script>
    var isEditable = true;
    var oldValues = {};

    $('#avatar').attr('src', '<%=curUser.getAvatar() != null ? curUser.getAvatar() : 13%>');

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

    $("#updateForm").submit(function (eventObj) {
        var userId = <%=curUser.getId()%>;
        $('<input />').attr('type', 'hidden')
            .attr('name', "id")
            .attr('value', userId)
            .appendTo('#updateForm');
        $('<input />').attr('type', 'hidden')
            .attr('name', "authority")
            .attr('value', '<%=curUser.getAuthority()%>')
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
        onEditClick();
    }
    onEditClick();
</script>

</html>
