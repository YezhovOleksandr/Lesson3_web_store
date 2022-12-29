<%@ page import="dto.UserDTO" %><%--
  Created by IntelliJ IDEA.
  User: Legion
  Date: 29.12.2022
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cabinet</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<%
    UserDTO user = (UserDTO) request.getAttribute("user");
%>

<div>
    <div>
        <b>Name : </b> <span> <%= user.getFirst_name() + " " + user.getLast_name()%></span>
        <b>Email : </b> <span> <%= user.getEmail()%></span>
    </div>
</div>
</body>
</html>
