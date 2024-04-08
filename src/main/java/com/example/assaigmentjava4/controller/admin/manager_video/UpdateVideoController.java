package com.example.assaigmentjava4.controller.admin.manager_video;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.assaigmentjava4.entity.Video;
import com.example.assaigmentjava4.service.VideoService;
import com.example.assaigmentjava4.service.impl.VideoServiceImpl;
import jakarta.servlet.http.Part;

@WebServlet("/edit-video")
public class UpdateVideoController extends HttpServlet {
    private VideoService videoService = new VideoServiceImpl();

    private static final String imageUpload = "C:\\Users\\Nguyen Hai Long\\IdeaProjects\\AssaigmentJava4\\src\\main\\webapp\\imageupload";
    private static final String vìdeoUpload = "C:\\Users\\Nguyen Hai Long\\IdeaProjects\\AssaigmentJava4\\src\\main\\webapp\\videoupload";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        System.out.println(title);
        System.out.println(description);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("/edit-video")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Video video = videoService.getVideoById(id);
            log(video + "");
            req.setAttribute("video", video);
            req.getRequestDispatcher("view/admin/manager_video/component/edit-video.jsp").forward(req, resp);
        }
    }


}
