package com.example.assaigmentjava4.controller;

import com.example.assaigmentjava4.entity.Users;
import com.example.assaigmentjava4.security.PasswordUntil;
import com.example.assaigmentjava4.service.UserService;
import com.example.assaigmentjava4.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fistName = req.getParameter("fistname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String hashPassword = PasswordUntil.hashPassword(password);
        String fullName = fistName+" "+lastName;
        boolean role = false;

        if(fistName != null && lastName != null && email != null && password != null){
            Users users = new Users();
            users.setEmail(email);
            users.setPassword(hashPassword);
            users.setFullName(fullName);
            users.setAdmin(role);
            int result = userService.addUser(users);
            if(result > 0){
                req.setAttribute("success","Đăng ký thành công");
                req.getRequestDispatcher("view/signup.jsp").forward(req,resp);
            }else {
                req.setAttribute("error","Đăng ký thất bại");
            }
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("/signup")){
            req.getRequestDispatcher("view/signup.jsp").forward(req,resp);
        }
    }
}
