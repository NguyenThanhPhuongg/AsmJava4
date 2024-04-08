package com.example.assaigmentjava4.controller.admin.manager_user;

import com.example.assaigmentjava4.entity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("/admin")){
            HttpSession session = req.getSession(false);
            if(session != null){
                Users users = (Users) session.getAttribute("user");
                if(users != null){
                    String userName = "Xin chào : " + users.getFullName();
                    req.setAttribute("userName",userName);
                    req.getRequestDispatcher("view/admin/admin_index.jsp").forward(req,resp);
                } else {
                    req.getRequestDispatcher("view/error/error401.jsp").forward(req,resp);
                }
            }

        }
    }
}
