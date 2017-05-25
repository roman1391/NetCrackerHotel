<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Hotel reviews</title>
</head>
<style>
    img {
        max-height: 50px;
        max-width: 50px;
        -webkit-border-radius: 50% !important;
        -moz-border-radius: 50% !important;
        border-radius: 50% !important;
    }
    .rounded{
        background: #F7F6ED;
    }
    .rounded ul{
        font-size: x-large;
        color: #1d1e1f;
        list-style: none;
    }
    .rounded ul span{
        color: #2a62bc;
    }

    a {
        font-size: 15pt;
    }

    a:hover{
        text-decoration: none;
    }
</style>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@include file="../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <div class="container">
        <sec:authorize access="hasRole('ADMIN')">
            <a href="${contextPath}/admin/hotel_page/${choosenHotel.id}"><i class="fa fa-arrow-circle-left" aria-hidden="true"></i> Back to hotel page </a>
        </sec:authorize>
        <sec:authorize access="!hasRole('ADMIN')">
            <a href="${contextPath}/hotel_page/${choosenHotel.id}"><i class="fa fa-arrow-circle-left" aria-hidden="true"></i> Back to hotel page </a>
        </sec:authorize>
        <c:if test="${fn:length(currentReviews) eq 0}">
            <h1>There is no any review left yet.</h1>
        </c:if>

            <c:if test="${fn:length(currentReviews) gt 0}">
              <c:forEach var="review" items="${currentReviews}">
                  <div class="rounded border-1">
                      <div class="row">
                        <div class="col-3">
                            <ul>
                                <li class="item">
                                    Username: <span>${review.username }</span>
                                </li>
                            </ul>

                        </div>
                        <div class="col-5">
                            <ul>
                                <li class="item">
                                    Date: <span>${review.date}</span>
                                </li>
                                <li class="item">
                                    Rating: <span>${review.rating}</span>
                                </li>
                                <li class="item">
                                    Text: <span>${review.text }</span>
                                </li>
                            </ul>
                        </div>
                      </div>
                  </div>
              </c:forEach>
            </c:if>
        </div>
    </div>
    <%@include file="../jsp_elements/_footer.jsp" %>
<script src="<c:url value="/resources/bootstrap-4.0.0-alpha.6-dist/js/bootstrap.js"/>"></script>
<script src="<c:url value="/resources/js/hotel.js"/>" type="text/javascript"></script>
</body>
</html>