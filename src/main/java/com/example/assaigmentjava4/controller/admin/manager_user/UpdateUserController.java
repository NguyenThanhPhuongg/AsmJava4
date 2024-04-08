package com.example.assaigmentjava4.controller.admin.manager_user;

import com.example.assaigmentjava4.entity.Users;
import com.example.assaigmentjava4.security.PasswordUntil;
import com.example.assaigmentjava4.service.UserService;
import com.example.assaigmentjava4.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/update-user")
public class UpdateUserController extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("/update-user")){
            HttpSession session = req.getSession(false);
            if(session != null){
                Users userInfor = (Users) session.getAttribute("user");
                if(userInfor != null){
                    String userName = "Xin chào : " + userInfor.getFullName();
                    req.setAttribute("userName",userName);
                    Users users = userService.getUserById(Integer.parseInt(req.getParameter("id")));
                    if(users != null){
                        req.setAttribute("user" , users);
                    }
                    req.getRequestDispatcher("view/admin/component/user/update_user.jsp").forward(req,resp);
                } else {
                    req.getRequestDispatcher("view/error/error401.jsp").forward(req,resp);
                }
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int id = Integer.parseInt(req.getParameter("id_user"));
         String email = req.getParameter("email");
         String pass =  req.getParameter("pass");
         String fullName = req.getParameter("fullname");
         String hashPassword = PasswordUntil.hashPassword(pass);
         boolean role = Boolean.parseBoolean(req.getParameter("role"));
         Users users = new Users();
         users.setId(id);
         users.setFullName(fullName);
         users.setEmail(email);
         users.setAdmin(role);
         users.setPassword(hashPassword);
         if(email!= null && pass != null && fullName != null ){
             int result = userService.updateUser(users);
             if(result > 0){
                 resp.sendRedirect(req.getContextPath()+"/manager-user");
             }

         }

    }
}
