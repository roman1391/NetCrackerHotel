<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form id="registrationForm" style="margin: 20px" action="register-user"
           method="post" modelAttribute="user">
    <div class="form-group">
        <form:label path="firstName">First name</form:label>
        <form:input path="firstName" type="text" class="form-control"
                    placeholder="First name" required="required"
                    data-validation="length alphanumeric"
                    data-validation-length="6-15"
                    data-validation-error-msg="First name has to be an alphanumeric value (6-15 chars)"
        />
        <form:errors path="firstName" cssClass="ui-state-error-text"/>
    </div>
    <div class="form-group">
        <form:label path="lastName">Last name</form:label>
        <form:input path="lastName" type="text" class="form-control"
                    placeholder="Last name" required="required"
                    data-validation="length alphanumeric"
                    data-validation-length="5-15"
                    data-validation-error-msg="Last name has to be an alphanumeric value (5-15 chars)"
        />
        <form:errors path="lastName" cssClass="ui-state-error-text"/>
    </div>
    <div class="form-group">
        <form:label path="email">Email</form:label>
        <form:input path="email" type="email" class="form-control"
                    placeholder="Email" required="required"
                    data-validation="email"
        />
        <form:errors path="email" cssClass="ui-state-error-text"/>
    </div>
    <div class="form-group">
        <form:label path="username">Login</form:label>
        <form:input path="username" type="text" class="form-control"
                    placeholder="Username" required="required"
                    data-validation="length"
                    data-validation-length="min4"
                    data-validation-error-msg="Login has to be min 4 chars"
        />
        <form:errors path="username" cssClass="ui-state-error-text"/>
    </div>
    <div class="form-group">
        <form:label path="password">Password</form:label>
        <form:password path="password" id="password" class="form-control"
                       placeholder="Password" required="required"
                       data-validation="length alphanumeric"
                       data-validation-length="6-15"
                       data-validation-error-msg="Password has to be an alphanumeric value (6-15 chars)"
        />
        <form:errors path="password" cssClass="ui-state-error-text"/>
    </div>
    <div class="form-group">
        <label for="confirmPassword">Confirm password</label>
        <input id="confirmPassword" class="form-control"
               placeholder="Confirm password" type="password"
               data-validation="confirmation"
               data-validation-confirm="password" required>
    </div>

    <div class="form-group">
        <form:button type="submit" class="btn btn-primary">Registration</form:button>
    </div>
</form:form>