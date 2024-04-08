<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Nguyen Hai Long
  Date: 3/5/2024
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>
    <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-***your-sha512-hash***" crossorigin="anonymous" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/admin/css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="./view/images/logoyt.png">

</head>
<body>
<div class="wrapper">
    <div class="main">
        <nav class="navbar navbar-expand px-4 py-3">
            <form action="#" class="d-none d-sm-inline-block">

            </form>
            <div class="navbar-collapse collapse">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item dropdown">
                        <div>${userName}</div>
                        <div class="dropdown-menu dropdown-menu-end rounded">
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Youtube</a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav">
                        <li class="sidebar-item">
                            <a href="${pageContext.request.contextPath}/manager-user" class="sidebar-link">
                                <i class="lni lni-user" style="background-color: black"></i>
                                <span style="color: black">Manager User</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a href="${pageContext.request.contextPath}/manager-video" class="sidebar-link">
                                <svg style="width: 16px; background-color: black" xmlns="http://www.w3.org/2000/svg"
                                     viewBox="0 0 448 512">
                                    <!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.-->
                                    <path fill="#fcfcfc"
                                          d="M282 256.2l-95.2-54.1V310.3L282 256.2zM384 32H64C28.7 32 0 60.7 0 96V416c0 35.3 28.7 64 64 64H384c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64zm14.4 136.1c7.6 28.6 7.6 88.2 7.6 88.2s0 59.6-7.6 88.1c-4.2 15.8-16.5 27.7-32.2 31.9C337.9 384 224 384 224 384s-113.9 0-142.2-7.6c-15.7-4.2-28-16.1-32.2-31.9C42 315.9 42 256.3 42 256.3s0-59.7 7.6-88.2c4.2-15.8 16.5-28.2 32.2-32.4C110.1 128 224 128 224 128s113.9 0 142.2 7.7c15.7 4.2 28 16.6 32.2 32.4z"/>
                                </svg>
                                <span style="margin-left: 13px; color: black">Manager Video</span>
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a href="${pageContext.request.contextPath}/logout" class="sidebar-link">
                                <i class="lni lni-exit" style="background-color: black"></i>
                                <span style="color: black">Logout</span>
                            </a>
                        </li>
                    </ul>
                    <div class="d-flex justify-content-end ml-50">
                        <form class="d-flex">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </div>
        </nav>
        <main class="content px-3 py-4">
            <div class="container-fluid">
                <div class="mb-3">
                    <h3 class="fw-bold fs-4 my-3">Add User</h3>
                    <div class="row justify-content-center"> <!-- Thêm justify-content-center để căn giữa form -->
                        <div class="col-6">
                            <div class="card">
                                <div class="card-body">
                                    <form action="${pageContext.request.contextPath}/add-user" method="post">
                                        <div class="row">
                                            <div class="col-12">
                                                <label>Email</label>
                                                <input id="email" type="email" class="form-control" name="email">
                                                <span class="text-danger">
                <% if (request.getAttribute("errors") != null) {
                    List<String> errors = (List<String>) request.getAttribute("errors");
                    for (String error : errors) {
                        if (error.startsWith("Email")) {
                %>
                <%= error %><br>
                <% }
                }
                } %>
            </span>
                                            </div>
                                            <div class="col-12">
                                                <label>Password</label>
                                                <input id="password" type="password" class="form-control" name="pass">
                                                <span class="text-danger">
                <% if (request.getAttribute("errors") != null) {
                    List<String> errors = (List<String>) request.getAttribute("errors");
                    for (String error : errors) {
                        if (error.startsWith("Password")) {
                %>
                <%= error %><br>
                <% }
                }
                } %>
            </span>
                                            </div>
                                            <div class="col-12">
                                                <label>Fullname</label>
                                                <input id="fullname" type="text" class="form-control" name="fullname">
                                                <span class="text-danger">
                <% if (request.getAttribute("errors") != null) {
                    List<String> errors = (List<String>) request.getAttribute("errors");
                    for (String error : errors) {
                        if (error.startsWith("Full name")) {
                %>
                <%= error %><br>
                <% }
                }
                } %>
            </span>
                                            </div>
                                            <div class="col-12">
                                                <label>Role</label>
                                                <select name="role" class="form-select"
                                                        aria-label="Default select example">
                                                    <option value="1">Admin</option>
                                                    <option value="0">User</option>
                                                </select>
                                                <span class="text-danger">
                <% if (request.getAttribute("errors") != null) {
                    List<String> errors = (List<String>) request.getAttribute("errors");
                    for (String error : errors) {
                        if (error.startsWith("Role")) {
                %>
                <%= error %><br>
                <% }
                }
                } %>
            </span>
                                            </div>
                                            <div class="col-12 text-success mt-3 text-center">
                                                ${success}
                                            </div>
                                            <div class="col-12 mt-3">
                                                <a href="${pageContext.request.contextPath}/manager-user">
                                                    <button type="button" class="btn btn-warning">Quay lại</button>
                                                </a>
                                                <button type="submit" class="btn btn-success">Add</button>
                                            </div>
                                        </div>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </main>


        <footer class="footer">
            <div class="container-fluid">
                <div class="row text-body-secondary">
                    <div class="col-6 text-start ">
                        <a class="text-body-secondary" href=" #">
                            <strong>CodzSwod</strong>
                        </a>
                    </div>
                    <div class="col-6 text-end text-body-secondary d-none d-md-block">
                        <ul class="list-inline mb-0">
                            <li class="list-inline-item">
                                <a class="text-body-secondary" href="#">Contact</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="text-body-secondary" href="#">About Us</a>
                            </li>
                            <li class="list-inline-item">
                                <a class="text-body-secondary" href="#">Terms & Conditions</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>

<script>
    let username = document.getElementById()
</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/view/admin/js/script.js"></script>
</body>
</html>