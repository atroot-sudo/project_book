package com.theoldzheng.project_book.serveice.impl;

import com.theoldzheng.project_book.dao.UserDAO;
import com.theoldzheng.project_book.dao.impl.UserDAOImpl;
import com.theoldzheng.project_book.pojo.User;
import com.theoldzheng.project_book.serveice.UserService;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.16 10:05
 */
public class UserServiceImpl implements UserService {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public void registerUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }


    @Override
    public boolean existUsername(String username) {
        if (userDAO.queryUserByUsername(username) == null){
//            System.out.println("用户名可用！");
            return false;
        }else {
            return true;
        }
    }
}
