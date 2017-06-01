<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 01.05.17
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Forgot Password</title>
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
                <c:if test="${message!=null}">
                    <div style="margin: 10px" class="alert alert-success" >
                            ${message}
                    </div>
                </c:if>
                <c:if test="${message==null}" >
                    <form action="/forgot_password" method="post">
                        <div class="form-group">
                            <div class="col-xs-4">
                                <label for="email" >Enter email:</label>
                                <input  id="email" name="email" class="form-control" type="email" placeholder="email"
                                        data-validation="email" required />
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Send</button>
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
