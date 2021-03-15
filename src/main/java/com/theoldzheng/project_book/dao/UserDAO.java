package com.theoldzheng.project_book.dao;

import com.theoldzheng.project_book.pojo.User;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.15 21:22
 */
public interface UserDAO {
    //定义抽象方法给实现类

    /**
     * 通过用户名查找用户
     * @param username 用户名
     * @return 如果返回为空，则说明没有用户
     */
    User queryUserByUsername(String username);

    /**
     * 通过用户名和密码查找用户
     * @param username
     * @param password
     * @return
     */
    User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 添加一名用户
     * @param user 一个用户对象
     * @return 返回-1添加失败
     */
    int saveUser(User user);

}
