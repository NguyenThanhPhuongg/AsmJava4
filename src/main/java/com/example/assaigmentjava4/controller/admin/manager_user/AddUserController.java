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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/add-user")
public class AddUserController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        String fullname = req.getParameter("fullname");
        Boolean role = Boolean.parseBoolean(req.getParameter("role"));
        List<String> errors = validateFormAdd(email, password, fullname);
        String hashPassword = PasswordUntil.hashPassword(password);
        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
        } else {
            Users user = new Users();
            user.setEmail(email);
            user.setPassword(hashPassword);
            user.setFullName(fullname);
            user.setAdmin(role);
            int result = userService.addUser(user);

            if (result > 0) {
                req.setAttribute("success", "Thêm mới thành công");
            } else {
                req.setAttribute("success", "Thêm mới thất bại");
            }
        }
        req.getRequestDispatcher("view/admin/component/user/add_user.jsp").forward(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("/add-user")) {
            HttpSession session = req.getSession(false);
            if (session != null) {
                Users user = (Users) session.getAttribute("user");
                if (user != null) {
                    String userName = "Xin chào : " + user.getFullName();
                    req.setAttribute("userName", userName);
                    req.getRequestDispatcher("view/admin/component/user/add_user.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("view/error/error401.jsp").forward(req, resp);
                }
            }
        }
    }

    private List<String> validateFormAdd(String email, String password, String fullName) {
        List<String> errors = new ArrayList<>();

        if (email.isBlank()) {
            errors.add("Email is not empty");
        }

        if (password.isBlank()) {
            errors.add("Password is not empty");
        }

        if (fullName.isBlank()) {
            errors.add("Full name is not empty");
        }
        return errors;
    }
}
