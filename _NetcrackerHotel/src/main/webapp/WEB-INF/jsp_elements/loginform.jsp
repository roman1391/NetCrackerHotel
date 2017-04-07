<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- <form:form  action="check-user" style="margin-top: 20px" method="post" modelAttribute="user">
    <div class="form-group">
        <form:input path="username" type="text" name="username" class="form-control"
                    placeholder="Username" required="required" />
    </div>
    <div class="form-group">
        <form:input path="password" type="password" name="password" id="password" class="form-control"
                    placeholder="Password" required="required" />
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Login</button>
        <a href="registration" class="btn btn-link">Register</a>
    </div>
</form:form> --%>

Spring-security form:
<br>
<c:if test="${not empty error}">
		${error}
	</c:if>
<form name='form_login' action="j_spring_security_check" method='POST'>
	<table>
		<tr>
			<td>User:</td>
			<td><input type='text' name='user_login' value=''></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type='password' name='password_login' /></td>
		</tr>
		<tr>
			<td></td>
			<td><input name="_spring_security_remember_me"
			type="checkbox" class="checkAdmin" /> <label for="remember_me">Remember me</label> </td>
		</tr>
		<tr>
			<td><input name="submit" type="submit" value="submit" /></td>
		</tr>
		<tr>
			<td><a href="registration" class="btn btn-link">Register</a></td>
		</tr>
	</table>
</form>