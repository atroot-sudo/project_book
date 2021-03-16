package com.theoldzheng.project_book.web;

import com.theoldzheng.project_book.pojo.User;
import com.theoldzheng.project_book.serveice.UserService;
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
 * @create 2021.3.16 10:28
 */
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        UserService userService = new UserServiceImpl();
        //检查验证码 先写死
        if ("abcd".equalsIgnoreCase(code)){
            //检查用户名是否可用
            if (userService.existUsername(username)){
                System.out.println("用户名不可用");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
            }else {
                userService.registerUser(new User(username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);
            }
        }else{
            System.out.println("验证码错误");
            //跳回注册页面
            //请求转发
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }
    }
}
