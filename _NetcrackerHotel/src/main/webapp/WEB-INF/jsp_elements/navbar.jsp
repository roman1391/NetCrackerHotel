<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="authority" value="${currentUser.authority.toString()}"/>

<nav class="navbar navbar-fixed-top navbar-toggleable-md navbar-light bg-faded">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="${contextPath}/home">Netcracker</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="nav navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <sec:authorize access="hasRole('ADMIN')">
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/admin_page">Admin page</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/profile">Profile</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/booked_room?id=${currentUser.id}">View all bookings</a>
                </li>
            </sec:authorize>
            <li class="nav-item">   
                <a class="nav-link" href="${contextPath}/search-page">Search hotels</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/about">About</a>
            </li>
            <sec:authorize access="!isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/login">Log in</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/registration">Sign up</a>
                </li>
             </sec:authorize>
             <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/j_spring_security_logout">Logout</a>
                </li>
             </sec:authorize>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>