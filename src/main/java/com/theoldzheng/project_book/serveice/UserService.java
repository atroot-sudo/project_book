package com.theoldzheng.project_book.serveice;

import com.theoldzheng.project_book.pojo.User;

/**
 * Description:服务层，用于编写业务逻辑
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.16 9:58
 */
public interface UserService {
    /**
     * 提供注册功能
     * @param user 传入一个user对象
     */
    void registerUser(User user);

    /**
     * 提供登录功能
     * @param user 传入一个user对象
     * @return 返回是否登录成功
     */
    User login(User user);

    /**
     * 判断用户名是否存在
     * @return  true(存在) or false(不存在)
     */
    boolean existUsername(String username);
}
