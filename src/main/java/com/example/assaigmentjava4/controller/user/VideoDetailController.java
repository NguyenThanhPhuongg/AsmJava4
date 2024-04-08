package com.example.assaigmentjava4.controller.user;

import com.example.assaigmentjava4.entity.Users;
import com.example.assaigmentjava4.entity.Video;
import com.example.assaigmentjava4.service.VideoDetailService;
import com.example.assaigmentjava4.service.VideoService;
import com.example.assaigmentjava4.service.impl.VideoDetailServiceImpl;
import com.example.assaigmentjava4.service.impl.VideoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/user-video-detail")
public class VideoDetailController extends HttpServlet {

    private VideoService videoService = new VideoServiceImpl();

    private final VideoDetailService videoDetailService = new VideoDetailServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("/user-video-detail")){
            this.detailVideo(req,resp);
        }
        this.loadVideo(req,resp);
    }

    private void detailVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        Video video = videoService.getVideoById(Integer.parseInt(id));
        List<Video> videoListLoad = videoDetailService.getAllVideoExitClick(Integer.parseInt(id));
        req.setAttribute("videoListLoad",videoListLoad);
        req.setAttribute("video",video);
        req.getRequestDispatcher("view/user/detail_video_user.jsp").forward(req,resp);
    }

    private void loadVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Users users = (Users) session.getAttribute("user");
            String userName = "Xin chào : " + users.getFullName();
            req.setAttribute("userName", userName);
        }
        List<Video> listVideo = videoService.getAllVideo();
        System.out.println(listVideo.size());
        req.setAttribute("listVideo",listVideo);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
