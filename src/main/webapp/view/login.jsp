<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Youtube</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="shortcut icon" type="image/x-icon" href="./view/images/logoyt.png">

</head>
<body>

<div class="container-fluid">
    <!-- Section: Design Block -->
    <section class="">
        <!-- Jumbotron -->
        <div class="px-4 py-5 px-md-5 text-center text-lg-start" style="background-color: hsl(0, 0%, 96%)">
            <div class="container">
                <div class="row gx-lg-5 align-items-center">
                    <h1 class="fw-bold ls-tight text-center" style="color: lightpink">
                        Welcom!<br/>
                    </h1>
                    <div class="col-lg-6 mb-5 mb-lg-0 align-items-center">
                        <div class="card" style="background-color: #FFF0F5">
                            <div class="card-body py-5 px-md-5">
                                <form action="${pageContext.request.contextPath}/login" method="post">
                                    <div class="text-center">
                                        <h2 class="fw-bold ls-tight text-center" style="color: lightpink">
                                            Login<br/>
                                        </h2>
                                    </div>
                                    <!-- Email input -->
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example3">Email address</label>
                                        <input name="email" type="email" id="form3Example3" class="form-control"/>

                                    </div>

                                    <!-- Password input -->
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example4">Password</label>
                                        <input name="password" type="password" id="form3Example4" class="form-control"/>

                                    </div>

                                    <!-- Checkbox -->
                                    <div class="form-check d-flex justify-content-center mb-4"
                                         style="margin-right: 127px">
                                        <input class="form-check-input me-2" type="checkbox" value=""
                                               id="form2Example33" checked/>
                                        <label class="form-check-label" for="form2Example33">
                                            Remember
                                        </label>
                                    </div>

                                    <!-- Submit button -->
                                    <button type="submit" class="btn btn-block mb-4" style="background-color: lightpink">
                                        Login
                                    </button>
                                    <% if (request.getAttribute("loginMsg") != null) { %>
                                    <div class="alert alert-danger" role="alert">
                                        <%= request.getAttribute("loginMsg") %>
                                    </div>
                                    <% } %>

                                    <% if (request.getAttribute("loginSuccess") != null) { %>
                                    <div class="alert alert-success" role="alert">
                                        <%= request.getAttribute("loginSuccess") %>
                                    </div>

                                    <script>
                                        setTimeout(function() {
                                            <% if (request.getAttribute("loginSuccess") != null && request.getAttribute("loginSuccess").equals("Đăng nhập thành công!")) { %>
                                            window.location.href = "<%= request.getContextPath() %>/admin";
                                            <% } %>
                                        }, 1000);
                                    </script>
                                    <% } %>

                                    <span class="mb-4" style="display: block">Bạn chưa có tài khoản?<a
                                            href="${pageContext.request.contextPath}/signup" style="color: hotpink">Signup</a></span>
                                    <!-- Register buttons -->
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 mb-5 mb-lg-0">
                        <img src="./view/images/gau.png" width="400px" height="550px">
                    </div>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="footer.jsp"/>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>

</body>
</html>
