<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form  action="check-user" style="margin-top: 20px" method="post" modelAttribute="user">
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
</form:form>