<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 15.05.17
  Time: 2:01
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>Feedback</title>
    <link href="<c:url value="/resources/jQuery-Form-Validator/form-validator/theme-default.min.css"/>"
          rel="stylesheet" type="text/css" />
</head>
<%@include file="../jsp_elements/_header.jsp"%>
<body>
     <div style="margin-top: 15px" class="container">
         <c:if test="${error!=null}">
             <div style="margin: 50px" class="alert alert-danger" >
                     ${error}
             </div>
         </c:if>
         <c:if test="${success!=null}">
             <div style="margin: 50px" class="alert alert-success" >
                     ${success}
             </div>
         </c:if>
         <form style="margin: auto" method="post" action="feedback">
             <div class="form-group">
                 <label>Subject:</label>
                 <input name="subject" type="text" class="form-control">
             </div>
             <div class="form-group">
                 <label>Message:</label>
                 <textarea name="message" type="text" class="form-control" rows="5"
                           data-validation="length"
                           data-validation-length="5-150"
                           data-validation-error-msg="Message have to be length from 5 to 150"
                           required></textarea>
             </div>
             <div class="btn-group">
                 <button style="float: left" class="btn btn-primary" type="submit">Send</button>
             </div>
         </form>
     </div>
</body>
<%@include file="../jsp_elements/_footer.jsp"%>
<script src="<c:url value="/resources/jQuery-Form-Validator/form-validator/jquery.form-validator.min.js"/>"
        type="text/javascript"></script>
<script src="<c:url value="/resources/js/validator_property.js"/>"
        type="text/javascript"></script>