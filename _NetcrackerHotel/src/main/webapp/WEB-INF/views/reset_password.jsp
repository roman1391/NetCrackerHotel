<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 02.05.17
  Time: 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Reset password</title>
    <link href="<c:url value="/resources/jQuery-Form-Validator/form-validator/theme-default.min.css"/>"
          rel="stylesheet" type="text/css" />
</head>
<%@include file="../jsp_elements/_header.jsp"%>
<body>
    <div id="wrapper" >
        <div class="row">
            <div style="margin: auto" class="col-8">
                <c:if test="${error!=null}">
                    <div style="margin: 10px" class="alert alert-danger" >
                            ${error}
                    </div>
                </c:if>
                <c:if test="${error==null}" >
                    <form action="/reset_password" method="post">
                        <div class="form-group">
                            <label for="password">Enter new password</label>
                            <input id="password" class="form-control" name="password"
                                   placeholder="New password" type="password" required
                                   data-validation="length alphanumeric"
                                   data-validation-length="6-15"
                                   data-validation-error-msg="Password has to be an alphanumeric value (6-15 chars)">
                        </div>
                        <div class="form-group">
                            <label for="confirmPassword">Confirm password</label>
                            <input id="confirmPassword" class="form-control"
                                   placeholder="Confirm password" type="password"
                                   data-validation="confirmation"
                                   data-validation-confirm="password" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Confirm</button>
                    </form>
                </c:if>
            </div>
        </div>
    </div>
</body>
<script src="<c:url value="/resources/jquery-ui-1.12.1.custom/jquery.js"/>"
        type="text/javascript"></script>
<script src="<c:url value="/resources/jQuery-Form-Validator/form-validator/jquery.form-validator.min.js"/>"
        type="text/javascript"></script>
<script src="<c:url value="/resources/js/validator_property.js"/>"
        type="text/javascript"></script>
<%@include file="../jsp_elements/_footer.jsp"%>
</html>
