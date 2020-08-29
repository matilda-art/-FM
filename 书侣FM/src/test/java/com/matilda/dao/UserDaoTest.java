package com.matilda.dao;

import com.matilda.model.User;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-29 17:20
 **/
//单元测试-白盒测试
public class UserDaoTest {

    @Test
    public void insert() {
        User user = new User();
        user.setUid(110);
        user.setUsername("matilda");
    }

    @Test
    public void select() throws SQLException {
        UserDao userDao = new UserDao();
        userDao.select("matilda","110");
    }
}
