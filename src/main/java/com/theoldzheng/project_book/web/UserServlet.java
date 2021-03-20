package com.theoldzheng.project_book.web;

import com.theoldzheng.project_book.pojo.User;
import com.theoldzheng.project_book.serveice.UserService;
import com.theoldzheng.project_book.serveice.impl.UserServiceImpl;
import com.theoldzheng.project_book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.20 11:37
 */
public class UserServlet extends BaseServlet {
    UserServiceImpl userService = new UserServiceImpl();
    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        UserService userService = new UserServiceImpl();
        //检查验证码 先写死
        if ("abcd".equalsIgnoreCase(code)) {
            //检查用户名是否可用
            if (userService.existUsername(username)) {
                System.out.println("用户名不可用");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.registerUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            System.out.println("验证码错误");
            //跳回注册页面
            //请求转发
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User(username, password));

        if (userService.login(user) != null) {
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
