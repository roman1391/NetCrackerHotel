<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 15.04.17
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>

<head>
    <title>Bad user</title>
</head>
<%@include file="../jsp_elements/_header.jsp"%>
<body>
 <div id="wrapper" >
     <div class="jumbotron">
         <div class="alert alert-danger">${message}</div>
         <a href="registration" class="btn btn-link">Register</a>
     </div>
 </div>
</body>
<%@include file="../jsp_elements/_footer.jsp"%>
</html>
