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
</head>
<body>
<form action="login" method="post">
    <div>
        <label for ="email">Email</label>
        <input type="email" id = "email" name = "email" placeholder="email">
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" id = "password" name="password" placeholder="password">
    </div>
    <input type="submit">
</form>

</body>
</html>
