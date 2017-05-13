<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<link type="text/css" rel="stylesheet" href="<c:url value="../../resources/font-awesome-4.7.0/css/font-awesome.min.css" />" />

<c:if test="${not empty error}">
	 ${error}
</c:if>
<div id="loginwrapper">
    <h1>Please Sign In</h1>
    <form style="margin-top: 20px" name='form_login' action="j_spring_security_check" method='POST'>
        <div class="input-group margin-bottom-sm">
            <span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span>
            <input  type="text" name="user_login" class="form-control"
                    placeholder="Username" required="required" />
        </div>
        <div class="input-group ">
            <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
            <input  type="password" name="user_password" id="password" class="form-control"
                    placeholder="Password" required="required" />
        </div>
        <div class="button-group">
                <label class="checkbox-inline">
                    <input style="margin-right: 5px" name="_spring_security_remember_me"
                           type="checkbox" class="checkAdmin">Remember me</label>
            <button style="margin-left:15px;" type="submit" class="btn btn-primary">Login</button>
        </div>
        <div class="button-group">
            <a href="/forgot_password" class="btn btn-link" >Forgot password ?</a>
            <a href="registration" class="btn btn-link">Register</a>
        </div>

    </form>
    <div class="form-group" >
        <div class="d-inline-block">
            <form action="<c:url value="/signin/facebook" />" method="POST">
                <input type="hidden" name="scope" value="public_profile,email" />
                <button type="submit" class="btn btn-link" >
                    <i class="fa fa-facebook-official fa-3x"></i>
                </button>
            </form>
        </div>
        <div class="d-inline-block">
            <form action="<c:url value="/signin/twitter" />" method="POST">
                <button type="submit" class="btn btn-link" >
                    <i class="fa fa-twitter-square fa-3x"></i>
                </button>
            </form>
        </div>
        <div class="d-inline-block">
            <form action="<c:url value="/signin/vkontakte" />" method="POST">
                <input type="hidden" name="scope" value="email" />
                <button type="submit" class="btn btn-link" >
                    <i class="fa fa-vk fa-3x"></i>
                </button>
            </form>
        </div>

    </div>
</div>

