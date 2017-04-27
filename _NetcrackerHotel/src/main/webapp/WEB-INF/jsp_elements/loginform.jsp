<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<link type="text/css" rel="stylesheet" href="<c:url value="../../resources/font-awesome-4.7.0/css/font-awesome.min.css" />" />

<c:if test="${not empty error}">
	 ${error}
</c:if>
<form style="margin-top: 20px" name='form_login' action="j_spring_security_check" method='POST'>
    <div class="form-group">
        <input  type="text" name="user_login" class="form-control"
                    placeholder="Username" required="required" />
    </div>
    <div class="form-group">
        <input  type="password" name="user_password" id="password" class="form-control"
                    placeholder="Password" required="required" />
    </div>
    <div class="form-group">
		<label class="checkbox-inline">
			<input style="margin-right: 5px" name="_spring_security_remember_me"
				   type="checkbox" class="checkAdmin">Remember me</label>
        <button type="submit" class="btn btn-primary">Login</button>
        <a href="registration" class="btn btn-link">Register</a>
    </div>
</form>

<form action="<c:url value="/signin/facebook" />" method="POST">
    <input type="hidden" name="scope" value="public_profile,email" />
    <button type="submit" class="btn btn-link" >
        <i class="fa fa-facebook-official fa-3x"></i>
    </button>
</form>

<form action="<c:url value="/signin/twitter" />" method="POST">
    <button type="submit" class="btn btn-link" >
        <i class="fa fa-twitter-square fa-3x"></i>
    </button>
</form>

