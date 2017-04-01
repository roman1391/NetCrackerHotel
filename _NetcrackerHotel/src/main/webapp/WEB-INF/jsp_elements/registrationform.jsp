<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form style="margin: 20px" action="registered-user" method="post" modelAttribute="user">
    <div class="form-group">
        <form:label path="firstName">First name</form:label>
        <form:input path="firstName" type="text" class="form-control"
                    placeholder="First name" required="required" />
        <form:errors path="firstName" cssClass="ui-state-error-text"/>
    </div>
    <div class="form-group">
        <form:label path="lastName">Last name</form:label>
        <form:input path="lastName" type="text" class="form-control"
                    placeholder="Last name" required="required" />
        <form:errors path="lastName" cssClass="ui-state-error-text"/>
    </div>
    <div class="form-group">
        <form:label path="email">Email</form:label>
        <form:input path="email" type="email" class="form-control"
                    placeholder="Email" required="required" />
        <form:errors path="email" cssClass="ui-state-error-text"/>
    </div>
    <div class="form-group">
        <form:label path="login">Login</form:label>
        <form:input path="login" type="text" class="form-control"
                    placeholder="Login" required="required" />
        <form:errors path="login" cssClass="ui-state-error-text"/>
    </div>
    <div class="form-group">
        <form:label path="password">Password</form:label>
        <form:password path="password" id="password" class="form-control"
                    placeholder="Password" required="required" />
        <form:errors path="password" cssClass="ui-state-error-text"/>
    </div>

    <div class="form-group">
        <form:button type="submit" class="btn btn-primary">Registration</form:button>
    </div>
</form:form>