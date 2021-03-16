package com.theoldzheng.project_book.dao.impl;

import com.theoldzheng.project_book.dao.BaseDAO;
import com.theoldzheng.project_book.dao.UserDAO;
import com.theoldzheng.project_book.pojo.User;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.15 21:37
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "SELECT *  FROM user WHERE username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT *  FROM user WHERE username = ? AND password =?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO user (username,password,email) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }


}