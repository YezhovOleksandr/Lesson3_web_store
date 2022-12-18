
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./CSS/from.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="login-box">
    <h2>Login</h2>
    <form action="register" method="post">
        <div class="user-box">
            <input type="text" id = "first_name" name = "first_name" placeholder="First name">
            <label>First name</label>
        </div>
        <div class="user-box">
            <input type="text" id = "last_name" name = "last_name" placeholder="Last name">
            <label>Email</label>
        </div>
        <div class="user-box">
            <input type="email" id = "email" name = "email" placeholder="email">
            <label>Email</label>
        </div>
        <div class="user-box">
            <input type="password" id = "password" name="password" placeholder="password">
            <label>Password</label>
        </div>
        <input type="submit">
        <div class="login-p-box">
            <p>Already have an account?<a href="login.jsp">Log in</a> </p>
        </div>
    </form>
</div>
</body>
</html>
