<c:if test="${not empty error}">
		${error}
	</c:if>
	<form style="margin-top: 20px" name='form_login' action="j_spring_security_check" method='POST'>
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
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>
		<!--<div class="form-group">
			<input type="text"  name='user_login' value='' class="form-control"
				   placeholder="Username" required="required" />
		</div>
		<div class="form-group">
			<input type="password" name="password_login" id="password" class="form-control"
				   placeholder="Password" required="required" />
		</div>
		<div class="form-group">
			<button name="submit" value="submit" type="submit" class="btn btn-primary">Login</button>
			<a href="registration" class="btn btn-link">Register</a>
		</div>
		-->
	</form>


