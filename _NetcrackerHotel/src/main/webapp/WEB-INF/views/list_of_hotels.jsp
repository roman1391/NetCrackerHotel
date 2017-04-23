<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="pg" uri="http://pagination/pagination-spring3.tld" %>
<html>
<head>
<title>List of users</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<%-- <link type="text/css" href="<c:url value="/resources/css/cssreset.css" />" rel="stylesheet" media="screen, projection"> --%>
<link type="text/css" href="<c:url value="/resources/css/seasonstat.css"/>?vi=<%=(new java.util.Random()).nextInt(10)%>${pageContext.session.id}" rel="stylesheet" media="screen, projection"/>
<link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />" rel="stylesheet">
</head>

<body>
	<%@include file="../jsp_elements/_header.jsp"%>
	<div id="wrapper">
		<div class="container">
			<div class="row row-offcanvas row-offcanvas-left">
				Admin page! <br>
				<div class="col-xs-12 col-sm-9">
					<div class="jumbotron">
					<h4>List of hotels: *в разработке*</h4>
						
	<div style="padding-top:50px;padding-bottom:50px;padding-left:30px;padding-right:30px;">
        <c:url value="${paginationResult.pageLink}" var="pageLink"/>
        <form:form id="pgform" method="post" modelAttribute="pparam" action="${pageLink}">
            <pg:pagination pparam="${pparam}" paginationResult="${paginationResult}">
                <jsp:attribute name="searchContent">
                      <table class="searchtable">
                        <tr>
                            <td class="caption" style="width:50px;">Filter:</td>
                            <td style="width:120px;">
                            <form:select path="typeOfService" cssStyle="width:110px;">
                               <form:option value="" label="-service-"/>
                               <form:option value="1" label="1 star"/>
                               <form:option value="2" label="2 stars"/>
                               <form:option value="3" label="3 stars"/>
                               <form:option value="4" label="4 stars"/>
                               <form:option value="5" label="5 stars"/>
                            </form:select>
                            </td>
                            <td style="width:200px;">
                                <%-- <form:select path="enabled">
                                   	<form:option value="" label="-enabled-"/>
                               		<form:option value="true" label="Enabled"/>
                               		<form:option value="false" label="Unenabled"/>
                                </form:select> --%>
                            </td>
                            <td style="width:80px;">Name:</td>
                            <td style="width:160px;"><form:input path="name" cssStyle="width:150px;"/></td>
                            <td style="width:75px;"><span class="button"><form:button id="searchButton" name="buttonAction" value="searchButton" class="button">Search</form:button></span></td>
                            <td style="width:75px;"><span class="button"><form:button id="clearButton" name="buttonAction" value="clearButton" class="button">Clear</form:button></span></td>
                        </tr>
                    </table>  
                </jsp:attribute>
                 <jsp:attribute name="controlButton">
                     <div style="padding-top:10px;">
                        <span class="button"><form:button id="deleteButton" name="buttonAction" value="deleteButton" class="button">Delete</form:button></span>
                        <span ><a href="hotel/add">Add new hotel</a></span>
                    </div> 
                </jsp:attribute>  
                <jsp:attribute name="columnsContent">
                <td class="cell"><span style="white-space:nowrap;"><c:out value="${bo.name}"/></span></td>
                    <td class="cell"><span><c:out value="${bo.typeOfService}"/></span></td>
                    <td class="cell"><span style="white-space:nowrap;"><c:out value="${bo.country}"/></span></td>
                    <td class="cell"><span><c:out value="${bo.city}"/></span></td> 
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