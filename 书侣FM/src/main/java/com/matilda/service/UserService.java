package com.matilda.service;

import com.matilda.dao.UserDao;
import com.matilda.model.User;

import java.sql.SQLException;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-26 11:43
 **/

//提供偏向业务角度的方法
    //由Servlet调用
public class UserService {
    private UserDao userDao;

    public UserService(){
        userDao = new UserDao();
    }

    public User register(String username,String password) throws SQLException {
        return userDao.insert(username,password);
    }

    public User login(String username,String password) throws SQLException {
        return userDao.select(username,password);
    }
}
