package com.theoldzheng.project_book.web;

import com.theoldzheng.project_book.pojo.User;
import com.theoldzheng.project_book.serveice.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.16 11:31
 */
public class loginServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        if (userService.login(new User(username, password)) != null) {
            System.out.println("登陆成功");
            //跳转登录成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        } else {
            //用户名或密码不正确 请求转发
            System.out.println("用户名密码不正确，或用户不存在！");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }


    }
}
