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
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<%@include file="../../jsp_elements/_header.jsp"%>
	<div id="wrapper">
		<div class="container">
			<div class="row row-offcanvas row-offcanvas-left">
				Admin page! <br> <a href="j_spring_security_logout">Logout</a>
				<div class="col-xs-12 col-sm-9">
					<div class="jumbotron">
						<h1>User editing:</h1>
						<div>
							<div>

								<div class="form-group">
									<label for="firstName">First name:</label> <input
										id="firstName" value="${user.firstName}"
										class="editable form-control" required>
								</div>
								<div class="form-group">
									<label for="lastName">Last name:</label> <input id="lastName"
										value="${user.lastName}" class="editable form-control"
										required>
								</div>
								<div class="form-group">
									<label for="username">Username:</label> <input id="username"
										value="${user.username}" class="editable form-control"
										required>
								</div>
								<div class="form-group">
									<label for="email">Email:</label> <input id="email"
										value="${user.email}" class="editable form-control" required>
								</div>
								<div class="form-group">
									<label for="enabled">Enabled:</label> <input id="enabled"
										value="${user.enabled}" class="editable form-control" required>
								</div>
								<div class="form-group">
									<label for="authority">Authority:</label> <input id="authority"
										value="${user.authority}" class="editable form-control"
										required>
								</div>

								<button onclick="onEditClick()" class="edit-btn">Edit</button>
								<button onclick="onSave()" class="save-btn">Save</button>
								<button onclick="onCancel()" class="cancel-btn">Cancel</button>


								<div class="form-group">
									<label for="password">Change password:</label> <input
										id="password" type="password" class="editablep form-control"
										required>
								</div>
								<button onclick="onEditClickp()" class="edit-btnp">Change</button>
								<button onclick="onSavep()" class="save-btnp">Save</button>
								<button onclick="onCancelp()" class="cancel-btnp">Cancel</button>

								<form:form id="deleteUser" action="delete_user"
									modelAttribute="user" method="post">
									<form:input path="username" type="hidden" name="username"
										value="${user.username}"></form:input>
									<form:button type="submit">Delete user</form:button>
								</form:form>

							</div>

							<a href="${contextPath}/admin/list_of_users">Back to list of users</a> <br> <a
								href="${contextPath}/admin/admin_page">To admin page</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@include file="../../jsp_elements/_footer.jsp"%>
	</div>
</body>

<!-- <script>
	var isEditable = true;
	var oldValues = {};
	function onEditClickp() {
		isEditable = !isEditable;
		if (isEditable) {
			$('input.editablep').each(function(index, data) {
				oldValues[index] = data.value;
			});
		}
		$('.editablep').attr("disabled", !isEditable);
		$('.save-btnp').css('display', isEditable ? 'block' : 'none');
		$('.cancel-btnp').css('display', isEditable ? 'block' : 'none');
		$('.edit-btnp').css('display', !isEditable ? 'block' : 'none');
	}

	function onSavep() {
		var userDTO = {};
		userDTO.id = $
		{
			user.id
		}
		;
		$('input.editablep').each(function(index, data) {
			userDTO[data.id] = data.value;
		});
		$.ajax({
			url : "update",
			method : "POST",
			data : userDTO
		}).done(function(msg) {
			console.log(msg);
			onEditClickp();
		});
	}

	function onCancelp() {
		$('input.editablep').each(function(index, data) {
			$(data).val(oldValues[index]);
		});
		onEditClickp();
	}
	onEditClickp();
</script> -->


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
        userDTO.id = ${user.id};
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

<script>
    var isEditable = true;
    var oldValues = {};
    function onEditClickp() {
        isEditable = !isEditable;
        if (isEditable) {
            $('input.editablep').each(function (index, data) {
                oldValues[index] = data.value;
            });
        }
        $('.editablep').attr("disabled", !isEditable);
        $('.save-btnp').css('display', isEditable ? 'block' : 'none');
        $('.cancel-btnp').css('display', isEditable ? 'block' : 'none');
        $('.edit-btnp').css('display', !isEditable ? 'block' : 'none');
    }

    function onSavep() {
        var userDTO = {};
        userDTO.id = ${user.id};
            $('input.editablep').each(function (index, data) {
                userDTO[data.id] = data.value;
            });
        $.ajax({
            url: "update",
            method: "POST",
            data: userDTO
        }).done(function (msg) {
            console.log(msg);
            onEditClickp();
        });
    }

    function onCancelp() {
        $('input.editablep').each(function (index, data) {
            $(data).val(oldValues[index]);
        });
        onEditClickp();
    }
    onEditClickp();
</script>




</html>