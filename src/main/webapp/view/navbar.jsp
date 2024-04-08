<%--navbar--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <div class="row w-100">
            <div class="col-4">
                <a class="navbar-brand" href="#" style="margin-left: 35px">
                    <img src="${pageContext.request.contextPath}/view/images/logoyt.png" width="32px" height="32px" style="margin-bottom: 5px"/>
                    <span>My Youtube</span>
                </a>
            </div>
            <div class="col-4">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" aria-label="Search">
                        <button class="btn" style="border-color: pink" type="submit">Search</button>
                    </form>
                </div>
            </div>
            <div class="col-4 d-flex align-items-center justify-content-center">
                <div class="row align-items-center">
                    <div class="col-2 text-center mx-4">
                        <a href="${pageContext.request.contextPath}/login" class="mx-1" id="loginLink">
                            <button class="btn" style="background-color: pink">Login</button>
                        </a>
                    </div>
                    <div class="col-4 text-center">
                        <a href="${pageContext.request.contextPath}/signup" class="mx-3" id="signupLink">
                            <button class="btn" style="background-color: darkgrey">Signup</button>
                        </a>
                    </div>
                    <div class="col-8" id="userNameContainer" style="display: flex;"> <span>${userName}</span></div>
                    <div class="col-1" id="logoutContainer" style="display: none;"><a href="${pageContext.request.contextPath}/logout">Logout</a></div>
                </div>
            </div>

        </div>
    </div>
</nav>

<script>
    const userName = "${userName}";
    const userNameContainer = document.getElementById('userNameContainer');
    const logoutContainer = document.getElementById('logoutContainer');
    const loginLink = document.getElementById('loginLink');
    const signupLink = document.getElementById('signupLink');

    if (userName) {
        userNameContainer.style.display = 'block';
        logoutContainer.style.display = 'block';
        loginLink.style.display = 'none';
        signupLink.style.display = 'none';
    } else {
        userNameContainer.style.display = 'none';
        logoutContainer.style.display = 'none';
        loginLink.style.display = 'block';
        signupLink.style.display = 'block';
    }
</script>
<%--navbar--%>

