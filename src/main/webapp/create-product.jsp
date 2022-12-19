<%--
  Created by IntelliJ IDEA.
  User: Legion
  Date: 19.12.2022
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1 style="text-align: center">
    Create new product
</h1>

<div style="width: 70%; margin: 0 auto">
    <form>
        <div class="mb-3">
            <label for="name" class="form-label">Name of the product</label>
            <input type="text" name = "name" class="form-control" id="name" placeholder="Name of the product">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <textarea class="form-control" name = "description" id="description" rows="3"></textarea>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price</label>
            <input type="number" name = "price" class="form-control" id="price" placeholder="0">
        </div>
        <input type="submit" class="btn-primary">
    </form>
</div>
</body>
</html>
