package com.matilda.dao;

import org.junit.Test;

import java.sql.SQLException;


/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-29 22:10
 **/
public class AudioDaoTest {

    @Test
    public void insert() throws SQLException {
        AudioDao audioDao = new AudioDao();
        audioDao.insert(222,"12","type",null);
    }

    @Test
    public void select() throws SQLException {
        AudioDao audioDao = new AudioDao();
        audioDao.select("12");
    }
}
