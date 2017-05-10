<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<title>Home</title>
<link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">
</head>
<body>
	<%@include file="../jsp_elements/_header.jsp"%>
	<script src="<c:url value= "/resources/tether-1.3.3/dist/js/tether.min.js" />" >
	</script>
	<script src="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/js/bootstrap.min.js" />" >
	</script>
	<div id="wrapper">
		<div class="container">
			<c:if test="${error!=null}">
				<div style="margin: 50px" class="alert alert-danger" >
									${error}
				</div>
			</c:if>
			<sec:authorize access="hasRole('BLOCKED')">
						<div style="margin: 50px" class="alert alert-danger">
							Profile was blocked!</div>
			</sec:authorize>
					<!--	<h1>Hello Netcrackers</h1>
					<sec:authorize access="isAuthenticated()">
						<h3>Current user - <sec:authentication property="principal.username"/> </h3><br>
					</sec:authorize>
					<sec:authorize access="!isAuthenticated()">
						<h3>Current user - ${currentUser.username } </h3><br>
					</sec:authorize>
					login admin <br> password 123 <br> login user <br>
					password 1234 <br>
					</div>-->
			<div id="carousel" class="carousel slide" data-ride="carousel">
							<!-- Menu -->
				<ol class="carousel-indicators">
					<li data-target="#carousel" data-slide-to="0" class="active"></li>
					<li data-target="#carousel" data-slide-to="1"></li>
					<li data-target="#carousel" data-slide-to="2"></li>
				</ol>

							<!-- Items -->
				<div class="carousel-inner">

					<div class="carousel-item active">
						<div class="carousel-caption" >
							<h1>Welcome to booking service.</h1>
							<p>Best service for booking hotels all over the world.</p>
						</div>
						<img class="img-responsive" src="http://res.cloudinary.com/netcrackerhotel/image/upload/v1494365838/slide1.jpg" alt="Slide 1" />
					</div>
					<div class="carousel-item">
						<div class="carousel-caption">
							<h1>Partners all over the world</h1>
							<p>Belarus, Russia, Spain, Indonesia i.e.</p>
						</div>
						<img class="img-responsive" src="http://res.cloudinary.com/netcrackerhotel/image/upload/v1494365838/slide2.jpg" alt="Slide 2" />
					</div>
					<div class="carousel-item ">
						<div class="carousel-caption">
							<h1>Enjoy it.</h1>
						</div>
						<img class="img-responsive" src="http://res.cloudinary.com/netcrackerhotel/image/upload/v1494365838/slide3.jpg" alt="Slide 3" />
					</div>
				</div>
				<a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<%@include file="../jsp_elements/_footer.jsp"%>
	</div>
</body>
<script>
    $(document).ready(function () {
        $('#carousel').carousel({
			interval: 6000
		});
    });
</script>
</html>

