<%--
  Created by IntelliJ IDEA.
  User: Legion
  Date: 17.12.2022
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="./CSS/from.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="login-box">
    <h2>Login</h2>
    <form action="login" method="post">
        <div class="user-box">
            <input type="email" id = "email" name = "email" placeholder="email">
            <label>Email</label>
        </div>
        <div class="user-box">
            <input type="password" id = "password" name="password" placeholder="password">
            <label>Password</label>
        </div>
        <%
        Object error =request.getParameter("error");
        %>
        <div class="login-box-error-message" style="display:<%=error ==null ? "none" : "block"%>">Incorrect login or password, please try again</div>
        <input type="submit">
        <div class="login-p-box">
            <p>Don't have an account?<a href="login.jsp">Register</a></p>
        </div>
    </form>
</div>

</body>
</html>
