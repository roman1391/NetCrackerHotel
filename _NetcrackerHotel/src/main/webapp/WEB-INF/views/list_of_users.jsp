<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="pg" uri="http://pagination/pagination-spring3.tld" %>
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
					<h3>List of users: *в разработке*</h3>
						
	<div style="padding-top:50px;padding-bottom:50px;padding-left:30px;padding-right:30px;">
        <c:url value="${paginationResult.pageLink}" var="pageLink"/>
        <form:form id="pgform" method="post" modelAttribute="pparam" action="${pageLink}">
            <pg:pagination pparam="${pparam}" paginationResult="${paginationResult}">
                <jsp:attribute name="searchContent">
                      <table class="searchtable">
                        <tr>
                            <td class="caption" style="width:50px;">Filter:</td>
                            <td style="width:120px;">
                            <form:select path="authority" cssStyle="width:110px;">
                               <form:option value="authority" label="--authority--"/>
                               <form:option value="ADMIN" label="ADMIN"/>
                               <form:option value="USER" label="USER"/>
                               <form:option value="BLOCKED" label="BLOCKED"/>
                            </form:select>
                            </td>
                            <td style="width:200px;">
                                <form:select path="enabled">
                                   	<form:option value="enabled" label="--enabled--"/>
                               		<form:option value="Enabled" label="Enabled"/>
                               		<form:option value="Unenabled" label="Unenabled"/>
                                </form:select>
                            </td>
                            <td style="width:80px;">Username:</td>
                            <td style="width:160px;"><form:input path="username" cssStyle="width:150px;"/></td>
                            <td style="width:75px;"><span class="button"><form:button id="searchButton" name="buttonAction" value="searchButton" class="button">Search</form:button></span></td>
                            <td style="width:75px;"><span class="button"><form:button id="clearButton" name="buttonAction" value="clearButton" class="button">Clear</form:button></span></td>
                        </tr>
                    </table>  
                </jsp:attribute>
                 <jsp:attribute name="controlButton">
                     <div style="padding-top:10px;">
                        <span class="button"><form:button id="deleteButton" name="buttonAction" value="deleteButton" class="button">Delete</form:button></span>
                        <span class="button"><form:button id="addButton" name="buttonAction" value="addButton" class="button">Add</form:button></span>
                    </div> 
                </jsp:attribute>  
                <jsp:attribute name="columnsContent">
                     <td class="cell"><span><c:out value="${bo.authority}"/></span></td>
                    <td class="cell"><span style="white-space:nowrap;"><c:out value="${bo.enabled}"/></span></td>
                    <td class="cell"><span style="white-space:nowrap;"><c:out value="${bo.username}"/></span></td>
                    <td class="cell"><span><c:out value="${bo.email}"/></span></td> 
                </jsp:attribute>
            </pg:pagination>
        </form:form>
    </div> 


						<a href="admin_page">Back to admin page</a>
					</div>
				</div>
			</div>
		</div>
		<%@include file="../jsp_elements/_footer.jsp"%>
	</div>
</body>


</html>

<%-- 						<h3>List of administrators:</h3>
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
							<a href="add_user_ref">Add new user</a>
						</div> --%>
						
						
<%-- 						<div style="padding-top:50px;padding-bottom:50px;padding-left:30px;padding-right:30px;">
        <c:url value="${paginationResult.pageLink}" var="pageLink"/>
        <form:form id="pgform" method="post" modelAttribute="pparam" action="${pageLink}">
            <pg:pagination pparam="${pparam}" paginationResult="${paginationResult}">
                <jsp:attribute name="searchContent">
                    <table class="searchtable">
                        <tr>
                            <td class="caption" style="width:50px;">Filter:</td>
                            <td style="width:120px;">
                            <form:select path="season" cssStyle="width:110px;">
                               <form:option value="" label="--- Season ---"/>
                               <form:option value="2009" label="2009"/>
                               <form:option value="2008" label="2008"/>
                            </form:select>
                            </td>
                            <td style="width:200px;">
                                <form:select path="teamName">
                                   <form:option value="" label="--- Team ---"/>
                                   <form:options items="${teamList}" />
                                </form:select>
                            </td>
                            <td style="width:80px;">Player Name:</td>
                            <td style="width:160px;"><form:input path="playerName" cssStyle="width:150px;"/></td>
                            <td style="width:75px;"><span class="button"><form:button id="searchButton" name="buttonAction" value="searchButton" class="button">Search</form:button></span></td>
                            <td style="width:75px;"><span class="button"><form:button id="clearButton" name="buttonAction" value="clearButton" class="button">Clear</form:button></span></td>
                        </tr>
                    </table>
                </jsp:attribute>
                <jsp:attribute name="controlButton">
                    <div style="padding-top:10px;">
                        <span class="button"><form:button id="deleteButton" name="buttonAction" value="deleteButton" class="button">Delete</form:button></span>
                        <span class="button"><form:button id="addButton" name="buttonAction" value="addButton" class="button">Add</form:button></span>
                    </div>
                </jsp:attribute>
                <jsp:attribute name="columnsContent">
                    <td class="cell"><span><c:out value="${bo.season}"/></span></td>
                    <td class="cell"><span style="white-space:nowrap;"><c:out value="${bo.playerName}"/></span></td>
                    <td class="cell"><span style="white-space:nowrap;" title="<c:out value="${bo.teamName}"/>"><c:out value="${bo.teamAlias}"/></span></td>
                    <td class="cell"><span><c:out value="${bo.position}"/></span></td>
                    <td class="cell" style="text-align:right;"><span><c:out value="${bo.gamePlay}"/></span></td>
                    <td class="cell" style="text-align:right;"><span><fmt:formatNumber type="number" value="${bo.minutePerGame}" pattern="###"></fmt:formatNumber></span></td>
                    <td class="cell" style="text-align:right;"><span><fmt:formatNumber type="number" value="${bo.fgPercent}" pattern="##0.0"></fmt:formatNumber></span></td>
                    <td class="cell" style="text-align:right;"><span><fmt:formatNumber type="number" value="${bo.tpPercent}" pattern="##0.0"></fmt:formatNumber></span></td>
                </jsp:attribute>
            </pg:pagination>
        </form:form>
    </div> --%>