package com.example.assaigmentjava4.controller.admin.manager_user;

import com.example.assaigmentjava4.entity.Users;
import com.example.assaigmentjava4.service.UserService;
import com.example.assaigmentjava4.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/manager-user")
public class ManagerUser extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("/manager-user")) {
            HttpSession session = req.getSession(false);
            if(session != null){
                Users user = (Users) session.getAttribute("user");
                if(user != null){
                    String userName = "Xin chào : " + user.getFullName();
                    req.setAttribute("userName",userName);
                    showAllUsers(req, resp);
                    String action = req.getParameter("action");
                    if ("delete".equals(action)) {
                        deleteUser(req, resp);
                    }
                } else {
                    req.getRequestDispatcher("view/error/error401.jsp").forward(req,resp);
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
    }


    private void showAllUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        List<Users> listUser = userService.getAllUsers();
        req.setAttribute("listUser", listUser);
        req.getRequestDispatcher("view/admin/component/user/manager_user.jsp").forward(req, resp);
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));
        System.out.println(userId);
        int result = userService.deleteUser(userId);
        if (result > 0) {
            System.out.println("Delete thành công");
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect(req.getContextPath() + "/manager-user");
        } else {
            System.out.println("Delete Thất bại");
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Delete thất bại");
        }
        resp.getWriter().flush();
    }



}
