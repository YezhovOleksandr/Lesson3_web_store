<%--
  Created by IntelliJ IDEA.
  User: Legion
  Date: 18.12.2022
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
  <%--    Bootstrap--%>
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  <!-- JavaScript Bundle with Popper -->
    <script src="https://kit.fontawesome.com/53dd0282ff.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script><script src="https://kit.fontawesome.com/53dd0282ff.js" crossorigin="anonymous"></script>
</head>
<body>
<header class="p-3 text-bg-dark">
  <div class="container">
    <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
<%--      <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">--%>
<%--        <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>--%>
<%--      </a>--%>

      <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
        <li><a href="index.jsp" class="nav-link px-2 text-white">Home</a></li>
          <li><a href="user" class="nav-link px-2 text-white">Cabinet </a></li>
        <li><a href="bucket.jsp" class="nav-link px-2 text-white">Bucket</a></li>
        <li id="create"><a href="create-product.jsp" class="nav-link px-2 text-white">Create product</a></li>
        <li><a href="#" class="nav-link px-2 text-white">Contacts</a></li>
      </ul>

      <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
        <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
      </form>
      <%
        String name=(String) session.getAttribute("userName");
        String role=(String) session.getAttribute("userRole");
      %>

      <div class="text-end">
                <span style="display: <%= name == null ? "inline" : "none"%>">
                <button type="button" class="btn btn-outline-light me-2">
                    <a href="login.jsp">Login</a>
                </button>
                <button type="button" class="btn btn-warning">
                    <a href="register.jsp">Sign-up</a>
                </button>
                    </span>
        <button style="display: <%= name != null ? "inline" : "none"%>"  type="button" class="btn btn-warning">
          <a href="logout">Log out</a>
        </button>

      </div>
    </div>
  </div>
</header>
<script>
    const  role = '<%=role%>'
    console.log(role)
    if (role !== 'ADMIN') {
        document.getElementById("create").setAttribute("hidden","hidden")
    }
    const item = localStorage.getItem('userId');
    const userIdFromSession = <%=session.getAttribute("userId")%>
    if (userIdFromSession !== item ) {
        localStorage.setItem('userId', userIdFromSession);
    }
</script>
</body>
</html>
