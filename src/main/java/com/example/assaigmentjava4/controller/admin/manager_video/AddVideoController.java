package com.example.assaigmentjava4.controller.admin.manager_video;


import com.example.assaigmentjava4.entity.Video;
import com.example.assaigmentjava4.service.VideoService;
import com.example.assaigmentjava4.service.impl.VideoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet("/add-video")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 1000,
        maxRequestSize = 1024 * 1024 * 1000)

public class AddVideoController extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "/videoupload";
    private VideoService videoService = new VideoServiceImpl();
    private static final String imageUpload = "D:\\Java4\\AssaigmentJava4\\src\\main\\webapp\\imageupload";
    private static final String vìdeoUpload = "D:\\Java4\\AssaigmentJava4\\src\\main\\webapp\\videoupload";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("/add-video")) {
            req.getRequestDispatcher("view/admin/manager_video/component/add-video.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String active = req.getParameter("active");
        Part videoPart = req.getPart("video");
        Part posterPart = req.getPart("poster");
        String videoName = Paths.get(videoPart.getSubmittedFileName()).getFileName().toString();
        String imageName = Paths.get(posterPart.getSubmittedFileName()).getFileName().toString();
        String videoFileName = formattedDateTime + "_" + videoName;
        String posterFileName = formattedDateTime + "_" + imageName;
        videoPart.write(vìdeoUpload + File.separator + videoFileName);
        posterPart.write(imageUpload + File.separator + posterFileName);


        if (title != null && description != null && active != null && videoPart != null && posterPart != null) {
            String video = videoFileName;
            String poster = posterFileName;
            Boolean activeBolean = Boolean.parseBoolean(active);
            Video videoSave = new Video();
            videoSave.setVideoName(video);
            videoSave.setTitle(title);
            videoSave.setPoster(poster);
            videoSave.setDescription(description);
            videoSave.setActive(activeBolean);
            int result = videoService.addVideo(videoSave);
            if (result > 0) {
                resp.sendRedirect(req.getContextPath() + "/manager-video");
            } else {
                req.getRequestDispatcher("view/admin/manager_video/component/add-video.jsp").forward(req, resp);
            }

        }


    }


}