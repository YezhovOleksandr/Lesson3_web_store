<%--
  Created by IntelliJ IDEA.
  User: Legion
  Date: 29.12.2022
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bucket</title>
  <link rel="stylesheet" href="CSS/bucket_product.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container bucket-container">
  <div class="bucket-item">
    <div class="bucket-image">
      <img width="150" height="150" alt="product" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeHL3u0EubwNCoSV1e6yDdnzrVt33uCKnt0Q&usqp=CAU">
    </div>
  </div>
  <div class="content">
    <h3>Name</h3>
    <p>
      Lorem ipsum dolor sit amet, consectetur.
    </p>
  </div>

  <div class="buttons">
    <button class="btn btn-danger">Remove</button>
  </div>
</div>
<div class="container bucket-container">
  <div class="bucket-item">
    <div class="bucket-image">
      <img width="150" height="150" alt="product" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeHL3u0EubwNCoSV1e6yDdnzrVt33uCKnt0Q&usqp=CAU">
    </div>
  </div>
  <div class="content">
    <h3>Name</h3>
    <p>
      Lorem ipsum dolor sit amet, consectetur.
    </p>
  </div>

  <div class="buttons">
    <button class="btn btn-danger">Remove</button>
  </div>
</div>

</body>
</html>
