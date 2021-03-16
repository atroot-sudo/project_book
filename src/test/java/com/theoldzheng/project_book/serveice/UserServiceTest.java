package com.theoldzheng.project_book.serveice;

import com.theoldzheng.project_book.pojo.User;
import com.theoldzheng.project_book.serveice.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {

    @Test
    public void registerUser() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.registerUser(new User("飞龙在天", "123456", "fly@qq.com"));
    }

    @Test
    public void login() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.login(new User("飞龙在天", "123456", "fly@qq.com"));
    }

    @Test
    public void existUsername() {
        UserServiceImpl userService = new UserServiceImpl();
        if (userService.existUsername("飞龙在天")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用");
        }

    }
}