<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS v5.2.1 -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-***your-sha512-hash***" crossorigin="anonymous" />
</head>
<style>
    .video-title {
        word-wrap: break-word;
        margin-top: 0;
    }

</style>

<body>
   <jsp:include page="/view/navbar.jsp" />
  <div class="container">
      <div class="row">
          <div class="col-7 ">
              <div class="mt-2">
                  <video style="border-radius: 10px" id="uploadedVideo" width="632px" src="${pageContext.request.contextPath}/video/${video.videoName}" type="video/mp4" autoplay controls></video>
              </div>
              <h1 class="mt-2 px-2">${video.title}</h1>
              <div style="height: 130px;width: 633px;margin-bottom: 20px; background-color:#dbdbdb" class="card mt-2 px-3">
                  <p>${video.description}</p>
              </div>
          </div>
          <div class="col-5 ">
              <c:forEach items="${videoListLoad}" var="item">
               <a style="text-decoration: none" href="${pageContext.request.contextPath}/user-video-detail?id=${item.id}">
                   <div class="row mt-2">
                       <div class="col-8 ">
                           <div class="mb-3 d-flex justify-content-end">
                               <img style="height: 160px;width: 265px;border-radius: 5px 5px 5px 5px;"
                                    src="${pageContext.request.contextPath}/img/${item.poster}" id="imageLoad"  alt=""/>
                           </div>
                       </div>
                       <div class="col-4">
                           <h1 style="font-size: 19px ; color: black; text-decoration: none">${item.title}</h1>
                           <div style="font-size: 16px ; color: black; text-decoration: none"> View: 1000</div>
                           <div style="font-size: 16px ; color: black; text-decoration: none"> Like: 1000</div>
                           <div style="font-size: 16px ; color: black; text-decoration: none"> Share: 1000</div>
                       </div>
                   </div>
               </a>
              </c:forEach>

          </div>
      </div>

  </div>
  <jsp:include page="/view/footer.jsp" />
<script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"
></script>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"
></script>
</body>
</html>
