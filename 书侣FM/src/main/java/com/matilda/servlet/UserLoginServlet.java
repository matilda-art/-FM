package com.matilda.servlet;

import com.matilda.model.User;
import com.matilda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-26 15:38
 **/

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //每次都带上utf-8的设置，字符集不会出问题
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //没有做参数正确性检查

        try {
            User user = userService.login(username,password);
            if(user == null){
                //没有注册成功
                //没有做太多易用性考虑：没有告诉用户错误原因
                resp.sendRedirect("/login.html");
                return;
            }

            //把当前用户种入session中，下次资源访问同时携带的登录用户信息
            HttpSession session = req.getSession();
            session.setAttribute("user",user);

            //跳转回首页
            resp.sendRedirect("/");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
