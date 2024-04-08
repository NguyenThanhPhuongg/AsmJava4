package com.example.assaigmentjava4.controller.admin.manager_video;

import com.example.assaigmentjava4.entity.Video;
import com.example.assaigmentjava4.service.VideoService;
import com.example.assaigmentjava4.service.impl.VideoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/manager-video")
public class ManagerVideoController extends HttpServlet {
    private VideoService videoService = new VideoServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("/manager-video")){
            List<Video> listVideo = videoService.getAllVideo();
            if(listVideo != null){
                req.setAttribute("listVideo",listVideo);
            }
           String action = req.getParameter("action");
            if("delete".equals(action)){
                deleteUser(req,resp);
                return;
            }

            req.getRequestDispatcher("view/admin/manager_video/admin_manager_video.jsp").forward(req,resp);
        }
    }

    private void deleteUser(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Video video = videoService.getVideoById(id);
        int result =  videoService.deleteVideo(id);
       if(result >  0){
          if(video != null){
              deleteFileImage(video.getPoster());
              deleteFileVideo(video.getVideoName());
          }
          response.sendRedirect(request.getContextPath() + "/manager-video");
       }

    }

    private void deleteFileImage(String fileName) {
        String uploadDirectoryPath = "C:\\Users\\Nguyen Hai Long\\IdeaProjects\\AssaigmentJava4\\src\\main\\webapp\\imageupload";
        File uploadDirectory = new File(uploadDirectoryPath);
        if (uploadDirectory.exists() && uploadDirectory.isDirectory()) {
            File[] files = uploadDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().equals(fileName)) {
                        if (file.delete()) {
                            System.out.println("File deleted successfully: " + fileName);
                        } else {
                            System.err.println("Failed to delete file: " + fileName);
                        }
                        return;
                    }
                }
            }
        }
        System.err.println("File not found: " + fileName);
    }

    private void deleteFileVideo(String fileName) {
        String uploadDirectoryPath = "C:\\Users\\Nguyen Hai Long\\IdeaProjects\\AssaigmentJava4\\src\\main\\webapp\\videoupload";
        File uploadDirectory = new File(uploadDirectoryPath);

        if (uploadDirectory.exists() && uploadDirectory.isDirectory()) {
            File[] files = uploadDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().equals(fileName)) {
                        if (file.delete()) {
                            System.out.println("File deleted successfully: " + fileName);
                        } else {
                            System.err.println("Failed to delete file: " + fileName);
                        }
                        return;
                    }
                }
            }
        }
        System.err.println("File not found: " + fileName);
    }
}
