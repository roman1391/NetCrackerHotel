<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="pg" uri="http://pagination/pagination-spring3.tld" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>List of users</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <%-- <link type="text/css" href="<c:url value="/resources/css/cssreset.css" />" rel="stylesheet" media="screen, projection"> --%>
    <link type="text/css"
          href="<c:url value="/resources/css/seasonstat.css"/>?vi=<%=(new java.util.Random()).nextInt(10)%>${pageContext.session.id}"
          rel="stylesheet" media="screen, projection"/>
    <link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/search.css" />" rel="stylesheet">
    <link href="<c:url value="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css"/>"
          rel="stylesheet"/>
    <link href="<c:url value="/resources/css/search.css" />" rel="stylesheet">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
</head>

<body>
<jsp:include page="/WEB-INF/jsp_elements/_header.jsp"></jsp:include>

<script src="<c:url value="/resources/jquery-ui-1.12.1.custom/jquery-ui.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/search.js"/>" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>
<div id="wrapper">
    <div class="container-fluid">
        <c:if test="${success!=null}">
            <div style="margin: 10px;width:300px;" class="alert alert-success">${success}</div>
        </c:if>
        <div class="row">
            <div class="col-2">
                <jsp:include page="/WEB-INF/jsp_elements/adminnav.jsp" />
            </div>
            <div style="margin: 0 auto" class="col-9">
                <div class="jumbotron">
                    <h4>List of users:</h4>
                    <span >Records per page:</span>
                    <span ><a href="${contextPath}/admin/list_of_users/5">5</a></span>
                    <span ><a href="${contextPath}/admin/list_of_users/10">10</a></span>
                    <span ><a href="${contextPath}/admin/list_of_users/25">25</a></span>
                    <span ><a href="${contextPath}/admin/list_of_users/50">50</a></span>
                    <div style="padding-top:15px;padding-left:5px;padding-right:10px;">
                        <c:url value="${paginationResult.pageLink}" var="pageLink"/>
                        <form:form id="pgform" method="post" modelAttribute="pparam" action="${pageLink}">
                            <pg:pagination pparam="${pparam}" paginationResult="${paginationResult}">
                <jsp:attribute name="searchContent">
                      <table class="searchtable">
                          <tr>
                              <td class="caption" style="width:50px;">Filter:</td>
                              <td style="width:120px;">
                            <form:select path="authority" cssStyle="width:110px;">
                               <form:option value="" label="-authority-"/>
                               <form:option value="ADMIN" label="ADMIN"/>
                               <form:option value="USER" label="USER"/>
                               <form:option value="BLOCKED" label="BLOCKED"/>
                            </form:select>
                              </td>
                              <td style="width:200px;">
                                <form:select path="enabled">
                                   	<form:option value="" label="-state-"/>
                               		<form:option value="1" label="Enabled"/>
                               		<form:option value="0" label="Deactivated"/>
                                </form:select>
                              </td>
                              <td style="width:80px;">Username:</td>


                              <td style="width:160px;">
                            <form:select path="username" class="form-control" id="selectUser" multiple="multiple" cssStyle="width:150px;">
                                <form:options items="${usernames}"/>
                            </form:select></td>

                              <td style="width:75px;"><span class="button">
                            <form:button id="searchButton" name="buttonAction" value="searchButton" class="button"  >Search</form:button></span></td>
                              <td style="width:75px;"><span class="button">
                            <form:button id="clearButton" name="buttonAction" value="clearButton" class="button">Clear</form:button></span></td>
                          </tr>
                      </table>
                </jsp:attribute>
                                <jsp:attribute name="controlButton">
                     <div style="padding-top:10px;">
                         <span class="button"><form:button id="deleteButton" name="buttonAction" value="deleteButton" class="button" onclick="clicked(event)">Deactivate</form:button></span>
                         <span ><a href="${contextPath}/admin/add_user_ref">Add new user</a></span>
                     </div>
                </jsp:attribute>

                            </pg:pagination>
                        </form:form>
                    </div>

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
    $('#clearButton').click(function() {
        $("#selectUser").val(null).trigger("change");
    });
</script>