<%--
  Created by IntelliJ IDEA.
  User: Legion
  Date: 29.12.2022
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>404</title>
  <link rel="stylesheet" href="./CSS/404.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="body-error-box">
<div class="noise"></div>
<div class="overlay"></div>
<div class="terminal">
  <h1>Error <span class="errorcode">404</span></h1>
  <p class="output">УПС...Схоже цієї сторінки не існує(</p>
  <p class="output">Ви можете<a href="javascript:history.back()">повернутись назад</a> or <a href="index.jsp">Повернутись на головну сторінку</a>.</p>
  <p class="output">Слава ЗСУ і гарного дня!</p>
</div>
</div>
</body>
</html>
