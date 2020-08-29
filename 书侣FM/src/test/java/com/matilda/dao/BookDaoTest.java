package com.matilda.dao;

import com.matilda.model.Book;
import com.matilda.model.User;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-29 22:03
 **/
public class BookDaoTest {

    @Test
    public void insert() throws SQLException {
        BookDao bookDao = new BookDao();
        bookDao.insert(new User(17,"matilda"),"莎士比亚");
    }

    @Test
    public void selectAll() throws SQLException {
        BookDao bookDao = new BookDao();
        bookDao.selectAll();
    }

    @Test
    public void selectByBid() throws SQLException {
        BookDao bookDao = new BookDao();
        bookDao.selectByBid(1234);
    }
}
