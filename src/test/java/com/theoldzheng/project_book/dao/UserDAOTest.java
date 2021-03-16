package com.theoldzheng.project_book.dao;

import com.theoldzheng.project_book.dao.impl.UserDAOImpl;
import com.theoldzheng.project_book.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOTest {

    @Test
    public void queryUserByUsername() {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.queryUserByUsername("张三");
        System.out.println(user);

    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.queryUserByUsernameAndPassword("哈利波特", "123456");
        System.out.println(user);
    }

    @Test
    public void saveUser() {
        User user = new User("李四", "123456","lisi@qq.com");
        UserDAOImpl userDAO = new UserDAOImpl();
        int i = userDAO.saveUser(user);
        System.out.println("影响了 " + i + "行数据");
    }
}