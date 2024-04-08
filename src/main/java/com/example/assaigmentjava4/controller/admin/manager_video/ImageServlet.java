package com.example.assaigmentjava4.controller.admin.manager_video;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@WebServlet("/img/*")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imageName = request.getPathInfo().substring(1);
        Path imgDir = Paths.get("D:\\Java4\\AssaigmentJava4\\src\\main\\webapp\\imageupload");

        try {
            Files.list(imgDir).forEach(file -> {
                if (file.getFileName().toString().equals(imageName)) {
                    try {
                        FileInputStream fis = new FileInputStream(file.toFile());
                        byte[] data = fis.readAllBytes();
                        fis.close();
                        String contentType = Files.probeContentType(file);
                        if (contentType != null) {
                            response.setContentType(contentType);
                        } else {
                            response.setContentType("application/octet-stream");
                        }
                        response.setContentLength(data.length);
                        response.getOutputStream().write(data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
