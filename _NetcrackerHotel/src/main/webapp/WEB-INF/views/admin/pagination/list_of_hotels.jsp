<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="pg" uri="http://pagination/pagination-spring3.tld" %>
<html>
<head>
    <title>List of hotels</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <%-- <link type="text/css" href="<c:url value="/resources/css/cssreset.css" />" rel="stylesheet" media="screen, projection"> --%>
    <link type="text/css"
          href="<c:url value="/resources/css/seasonstat.css"/>?vi=<%=(new java.util.Random()).nextInt(10)%>${pageContext.session.id}"
          rel="stylesheet" media="screen, projection"/>
    <link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />" rel="stylesheet">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
    <link href="<c:url value="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css"/>"
          rel="stylesheet"/>
    <link href="<c:url value="/resources/css/search.css" />" rel="stylesheet">
</head>

<body>
	<jsp:include page="/WEB-INF/jsp_elements/_header.jsp"></jsp:include>
	<div id="wrapper">
		<div class="container">
			<div class="row row-offcanvas row-offcanvas-left">
				Admin page! <br>
				<div class="col-xs-12 col-sm-9">
					<div class="jumbotron">
					<h4>List of hotels:</h4>

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
                               <form:option value="" label="-class-"/>
                               <form:option value="1" label="1 star"/>
                               <form:option value="2" label="2 stars"/>
                               <form:option value="3" label="3 stars"/>
                               <form:option value="4" label="4 stars"/>
                               <form:option value="5" label="5 stars"/>
                            </form:select>
                            </td>
                            <td style="width:200px;"></td>
                            <td style="width:80px;">Name:</td>
                            <td style="width:160px;">
                            <form:select path="name" class="form-control" id="selectHotel" multiple="multiple" cssStyle="width:150px;">
                                <form:options items="${hotels}"/>
                            </form:select></td>
                            <td style="width:75px;"><span class="button"><form:button id="searchButton" name="buttonAction" value="searchButton" class="button">Search</form:button></span></td>
                            <td style="width:75px;"><span class="button"><form:button id="clearButton" name="buttonAction" value="clearButton" class="button">Clear</form:button></span></td>
                        </tr>
                    </table>
                </jsp:attribute>
                 <jsp:attribute name="controlButton">
                     <div style="padding-top:10px;">
                        <span class="button"><form:button id="deleteButton" name="buttonAction" value="deleteButton" class="button" onclick="clicked(event)">Delete</form:button></span>
                        <span ><a href="hotel/add">Add new hotel</a></span>
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
    <script src="<c:url value="/resources/jquery-ui-1.12.1.custom/jquery-ui.js"/>" type="text/javascript"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>
    <script src="<c:url value="/resources/js/search.js"/>" type="text/javascript"></script>
</body>
</html>

<script>
    function clicked(e) {
        if (!confirm('Are you sure?')) e.preventDefault();
    }
    $('#clearButton').click(function () {
        $("#selectHotel").val(null).trigger("change");
    });
</script>