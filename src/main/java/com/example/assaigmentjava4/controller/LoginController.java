package com.example.assaigmentjava4.controller;

import com.example.assaigmentjava4.entity.Users;
import com.example.assaigmentjava4.security.PasswordUntil;
import com.example.assaigmentjava4.service.UserService;
import com.example.assaigmentjava4.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("/login")){
            req.getRequestDispatcher("view/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (email != null && password != null) {
            Users user = userService.checkLogin(email);

            if (user != null && PasswordUntil.checkPassword(password, user.getPassword())) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                if (user.getAdmin()) {
                    req.setAttribute("loginSuccess", "Đăng nhập thành công!");
                    req.getRequestDispatcher("view/login.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect(req.getContextPath() + "/user-video");
                }
            } else {
                req.setAttribute("loginMsg", "Sai tài khoản hoặc mật khẩu");
                req.getRequestDispatcher("view/login.jsp").forward(req, resp);
            }
        }
    }

}
