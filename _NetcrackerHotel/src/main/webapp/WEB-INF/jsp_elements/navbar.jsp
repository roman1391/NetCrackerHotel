<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${contextPath}/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <c:if test="${authority eq 'ADMIN'}">
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/admin_page">Admin page</a>
                </li>
            </c:if>
            <c:if test="${authority ne 'GUEST'}">
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/profile">Profile</a>
                </li>
            </c:if>
            <c:if test="${authority ne 'GUEST'}">
                <li class="nav-item">
                    <form:form method="post" id="curUser" action="${contextPath}/booked_room" modelAttribute="currentUser">
                        <form:input path="id" type="hidden" name="id" value="${currentUser.id}"></form:input>
                        <form:input path="username" type="hidden" name="username" value="${currentUser.username}"></form:input>
                        <%-- <form:button class="nav-link" type="submit">Book</form:button> --%>
                        <form:button class="nav-link" type="submit">Booked rooms</form:button>

                        <!-- <a class="nav-link" type="submit" href="">Hotels</a> -->
                    </form:form>
                </li>
            </c:if>
            <li class="nav-item">   
                <a class="nav-link" href="${contextPath}/search-page">Search hotels</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/about">About</a>
            </li>
            <c:choose>
                <c:when test="${authority eq 'GUEST'}">
                    <li class="nav-item">
                        <a class="nav-link" href="${contextPath}/login">Log in</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${contextPath}/registration">Sign up</a>
                    </li>
                </c:when>
                <c:when test="${authority ne 'GUEST'}">
                    <li class="nav-item">
                        <a class="nav-link" href="${contextPath}/j_spring_security_logout">Logout</a>
                    </li>
                </c:when>
            </c:choose>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>