package com.example.assaigmentjava4.controller.admin.manager_video;

import com.example.assaigmentjava4.entity.Video;
import com.example.assaigmentjava4.service.VideoService;
import com.example.assaigmentjava4.service.impl.VideoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/detail-video")
public class DetailController extends HttpServlet {
    private  static final VideoService videoService = new VideoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String url = req.getRequestURI();
       if(url.contains("/detail-video")){
           int id = Integer.parseInt(req.getParameter("id"));
           Video video = videoService.getVideoById(id);
           req.setAttribute("video", video);
           req.getRequestDispatcher("view/admin/manager_video/component/detail-video.jsp").forward(req,resp);
       }
    }


}
