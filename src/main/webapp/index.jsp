<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="shortcut icon" type="image/x-icon" href="./view/images/logoyt.png">
    <title>Youtube</title>
</head>
<body>
 <jsp:include page="view/navbar.jsp"/>
<%-- video--%>
  <div class="container-fluid">
      <div class="row">
          <div class="col-1 mr-40">
              <div class="container-fluid">
                  <div class="row mt-5">
                      <div class="panel panel-default">
                          <div class="panel-heading" style="border: 1px">
                              <span class="glyphicon glyphicon-th-list"></span>
                              <strong>My Repo</strong>
                          </div>
                          <div class="list-group" border="1">
                                  <button style="color: black ; margin-right: 4px;" class="list-group-item">
                                      <i class='fas fa-home' style='font-size:24px;color:pink'></i><br>
                                      <h6 style="font-size: 0.8rem; text-decoration: none ">Home</h6>
                                  </button>
                                  <button style="color: black" class="list-group-item">
                                      <img src="view/images/favourite.png"><br>
                                      <h6 style="font-size: 0.8rem; text-decoration: none">Favorite</h6>
                                  </button>
                                  <button style="color: black" class="list-group-item">
                                      <i class="fa fa-history" style="font-size:24px;color:pink"></i><br>
                                      <h6 style="font-size: 0.8rem; text-decoration: none">History</h6>
                                  </button>
                              <button style="color: black" class="list-group-item">
                                  <i class="material-icons" style="font-size:24px;color:pink">&#xe8b8;</i>
                                  <br>
                                  <h6 style="font-size: 0.8rem; text-decoration: none">Setting</h6>
                              </button>
                              <button style="color: black" class="list-group-item">
                                  <i class='far fa-question-circle' style='font-size:24px ;color:pink'></i><br>
                                  <h6 style="font-size: 0.8rem; text-decoration: none">Help</h6>
                              </button>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
          <%--offcanvas--%>
          <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasFavorite">
              <div class="offcanvas-header">
                  <h5 class="offcanvas-title">Favorite Items</h5>
                  <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
              </div>
              <div class="offcanvas-body" style="overflow-y: auto; max-height: 100vh;">
                  <div class="row mt-2">
                      <div class="col-12 mb-3">
                          <div class="card" style="width: 300px;margin-left: 14px">
                              <a href=""><img src="${pageContext.request.contextPath}/view/images/hqdefault.jpg" class="card-img-top" alt="..." style="width: 300px; height: 200px;"></a>
                              <div class="card-body" >
                                  <h5 class="card-title">Card title</h5>
                                  <p class="card-text">bulk of the card's content.</p>
                                  <div class="d-flex justify-content-end">
                                      <button class="btn btn-primary ml-2"><i class="fas fa-share-alt"></i> Share</button>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="col-12 mb-3">
                          <div class="card" style="width: 300px;margin-left: 14px">
                              <a href=""><img src="${pageContext.request.contextPath}/view/images/hqdefault.jpg" class="card-img-top" alt="..." style="width: 300px; height: 200px;"></a>
                              <div class="card-body" >
                                  <h5 class="card-title">Card title</h5>
                                  <p class="card-text">bulk of the card's content.</p>
                                  <div class="d-flex justify-content-end">
                                      <button class="btn btn-primary ml-2"><i class="fas fa-share-alt"></i> Share</button>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="col-12 mb-3">
                          <div class="card" style="width: 300px;margin-left: 14px">
                              <a href=""><img src="${pageContext.request.contextPath}/view/images/hqdefault.jpg" class="card-img-top" alt="..." style="width: 300px; height: 200px;"></a>
                              <div class="card-body" >
                                  <h5 class="card-title">Card title</h5>
                                  <p class="card-text">bulk of the card's content.</p>
                                  <div class="d-flex justify-content-end">
                                      <button class="btn btn-primary ml-2"><i class="fas fa-share-alt"></i> Share</button>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="col-12 mb-3">
                          <div class="card" style="width: 300px;margin-left: 14px">
                              <a href=""><img src="${pageContext.request.contextPath}/view/images/hqdefault.jpg" class="card-img-top" alt="..." style="width: 300px; height: 200px;"></a>
                              <div class="card-body" >
                                  <h5 class="card-title">Card title</h5>
                                  <p class="card-text">bulk of the card's content.</p>
                                  <div class="d-flex justify-content-end">
                                      <button class="btn btn-primary ml-2"><i class="fas fa-share-alt"></i> Share</button>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="col-12 mb-3">
                          <div class="card" style="width: 300px;margin-left: 14px">
                              <a href=""><img src="${pageContext.request.contextPath}/view/images/hqdefault.jpg" class="card-img-top" alt="..." style="width: 300px; height: 200px;"></a>
                              <div class="card-body" >
                                  <h5 class="card-title">Card title</h5>
                                  <p class="card-text">bulk of the card's content.</p>
                                  <div class="d-flex justify-content-end">
                                      <button class="btn btn-primary ml-2"><i class="fas fa-share-alt"></i> Share</button>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="col-12 mb-3">
                          <div class="card" style="width: 300px;margin-left: 14px">
                              <a href=""><img src="${pageContext.request.contextPath}/view/images/hqdefault.jpg" class="card-img-top" alt="..." style="width: 300px; height: 200px;"></a>
                              <div class="card-body" >
                                  <h5 class="card-title">Card title</h5>
                                  <p class="card-text">bulk of the card's content.</p>
                                  <div class="d-flex justify-content-end">
                                      <button class="btn btn-primary ml-2"><i class="fas fa-share-alt"></i> Share</button>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>

          </div>
          <%--offcanvas--%>
           <div class="col-11 mt-5">
               <div class="row">
                   <c:forEach var="video" items="${listVideo}">

                       <div class="col-3">
                           <a href="${pageContext.request.contextPath}/user-video-detail?id=${video.id}">
                               <div class="card" style="width: 300px;">
                                   <a href="${pageContext.request.contextPath}/user-video-detail?id=${video.id}"><img
                                           src="${pageContext.request.contextPath}/img/${video.poster}"
                                           class="card-img-top" alt="..." style="width: 300px; height: 200px;"></a>
                                   <div class="card-body">
                                       <h5 class="card-title">${video.title}</h5>
                                       <p class="card-text">${video.description}</p>
                                       <span style="color: #606060" class="card-text">3000000000 View</span>
                                       <div class="d-flex justify-content-end">
                                           <button style="margin-right: 5px" class="btn btn-primary ml-2"><i
                                                   class="fas fa-thumbs-up"></i> Like
                                           </button>
                                           <button class="btn btn-primary ml-2"><i class="fas fa-share-alt"></i> Share
                                           </button>
                                       </div>
                                   </div>
                               </div>
                           </a>
                       </div>

                   </c:forEach>
               </div>
           </div>
      </div>

  </div>

<%--footer--%>
 <jsp:include page="view/footer.jsp" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/view/js/config_offcanvas.js"></script>

</body>
</html>
