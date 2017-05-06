<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="pg" uri="http://pagination/pagination-spring3.tld" %>
<html>
<head>
<title>List of reviews</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<%-- <link type="text/css" href="<c:url value="/resources/css/cssreset.css" />" rel="stylesheet" media="screen, projection"> --%>
<link type="text/css" href="<c:url value="/resources/css/seasonstat.css"/>?vi=<%=(new java.util.Random()).nextInt(10)%>${pageContext.session.id}" rel="stylesheet" media="screen, projection"/>
<link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp_elements/_header.jsp"></jsp:include>
	<div id="wrapper">
		<div class="container">
			<div class="row row-offcanvas row-offcanvas-left">
				Admin page! <br>
				<div class="col-xs-12 col-sm-9">
					<div class="jumbotron">
					<h4>List of reviews:</h4>
						
	<div style="padding-top:50px;padding-bottom:50px;padding-left:30px;padding-right:30px;">
        <c:url value="${paginationResult.pageLink}" var="pageLink"/>
        <form:form id="pgform" method="post" modelAttribute="pparam" action="${pageLink}">
            <pg:pagination pparam="${pparam}" paginationResult="${paginationResult}">
                <jsp:attribute name="searchContent">
                      <table class="searchtable">
                        <tr>
                            <td class="caption" style="width:50px;">Filter:</td>
                            <td style="width:120px;">
                            <form:select path="status" cssStyle="width:110px;">
                               <form:option value="" label="-status-"/>
                               <form:option value="pending" label="Pending"/>
                               <form:option value="approved" label="Approved"/>
                               <form:option value="blocked" label="Blocked"/>
                            </form:select>
                            </td>
                            <td style="width:80px;">Username:</td>
                            <td style="width:160px;"><form:input path="username" cssStyle="width:150px;"/></td>
                            <td style="width:75px;"><span class="button"><form:button id="searchButton" name="buttonAction" value="searchButton" class="button"  >Search</form:button></span></td>
                            <td style="width:75px;"><span class="button"><form:button id="clearButton" name="buttonAction" value="clearButton" class="button">Clear</form:button></span></td>
                        </tr>
                    </table>  
                </jsp:attribute>
                 <jsp:attribute name="controlButton">
                     <div style="padding-top:10px;">
                        <span class="button"><form:button id="deleteButton" name="buttonAction" value="deleteButton" class="button" onclick="clicked(event)">Delete</form:button></span>
                    </div> 
                </jsp:attribute>  
                
            </pg:pagination>
        </form:form>
    </div> 


						<a href="admin_page">Back to admin page</a>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/jsp_elements/_footer.jsp"></jsp:include>
	</div>
</body>
</html>

<script>
function clicked(e)
{
    if(!confirm('Are you sure?'))e.preventDefault();
}
</script>
