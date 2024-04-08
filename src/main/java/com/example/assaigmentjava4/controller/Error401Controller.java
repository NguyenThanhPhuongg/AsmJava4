package com.example.assaigmentjava4.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/error401")
public class Error401Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String url = req.getRequestURI();
       if(url.contains("/error401")){
           req.getRequestDispatcher("view/error/error401.jsp").forward(req,resp);
       }
    }
}
