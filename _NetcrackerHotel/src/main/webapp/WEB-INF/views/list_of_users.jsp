<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Home</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link
	href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
	rel="stylesheet">

</head>

<body>
	<%@include file="../jsp_elements/_header.jsp"%>
	<div id="wrapper">
		<div class="container">
			<div class="row row-offcanvas row-offcanvas-left">
				Admin page! <br> <a href="j_spring_security_logout">Logout</a>
				<div class="col-xs-12 col-sm-9">
					<div class="jumbotron">
						<h3>List of administrators:</h3>
						<div>
							<table border="1">
								<tr>
									<th>Username</th>
									<th>Profile</th>
								</tr>
								<c:forEach var="user" items="${users}">
									<c:if test="${user.authority eq 'ADMIN'}">
										<tr>
											<td>${user.username}</td>
											<td><form:form id="editUser" action="edit_form"
													modelAttribute="user" method="post">
													<form:input path="username" type="hidden" name="username"
														value="${user.username}"></form:input>
													<form:button type="submit">See profile</form:button>
												</form:form></td>
										</tr>
									</c:if>
								</c:forEach>
							</table>
						</div>

						<h3>List of users:</h3>
						<div>
							<table border="1">
								<tr>
									<th>Username</th>
									<th>Status</th>
									<th>Profile</th>
									<th>Block</th>
								</tr>
								<c:forEach var="user" items="${users}">
									<c:if test="${user.authority ne 'ADMIN'}">
										<tr>
											<td>${user.username}</td>
											<td>${user.authority}</td>
											<td><form:form id="editUser" action="edit_form"
													modelAttribute="user" method="post">
													<form:input path="username" type="hidden" name="username"
														value="${user.username}"></form:input>
													<form:button type="submit">See profile</form:button>
												</form:form></td>
											<c:choose>
												<c:when test="${user.authority ne 'BLOCKED' }">
													<td><form:form id="blockUser" action="block_user"
															modelAttribute="user" method="post">
															<form:input path="username" type="hidden" name="username"
																value="${user.username}"></form:input>
															<form:button type="submit">Block</form:button>
														</form:form></td>
												</c:when>
												<c:when test="${user.authority eq 'BLOCKED' }">
													<td><form:form id="unblockUser" action="unblock_user"
															modelAttribute="user" method="post">
															<form:input path="username" type="hidden" name="username"
																value="${user.username}"></form:input>
															<form:button type="submit">Unblock</form:button>
														</form:form></td>
												</c:when>
											</c:choose>
										</tr>
									</c:if>
								</c:forEach>
							</table>
							<a href="admin_page">Back to admin page</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@include file="../jsp_elements/_footer.jsp"%>
	</div>
</body>


</html>