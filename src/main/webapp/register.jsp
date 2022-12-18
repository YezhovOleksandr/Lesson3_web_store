
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="register" method="post">
    <div>
        <label for ="first_name">First name</label>
        <input type="text" id = "first_name" name = "first_name" placeholder="First name">
    </div>
    <div>
        <label for ="last_name">Last name</label>
        <input type="text" id = "last_name" name = "last_name" placeholder="Last name">
    </div>
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
