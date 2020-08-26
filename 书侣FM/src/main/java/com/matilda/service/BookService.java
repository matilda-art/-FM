package com.matilda.service;

import com.matilda.dao.BookDao;
import com.matilda.dao.SectionDao;
import com.matilda.model.Book;
import com.matilda.model.Section;
import com.matilda.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-26 15:53
 **/
public class BookService {
    private BookDao bookDao;
    private SectionDao sectionDao;

    public BookService(){
        bookDao = new BookDao();
        sectionDao = new SectionDao();
    }

    public List<Book> list() throws SQLException {
        return bookDao.selectAll();
    }

    public Book post(String title, User user) throws SQLException {
        return bookDao.insert(user,title);
    }

    public Book get(int bid) throws SQLException{
        Book book = bookDao.selectByBid(bid);
        if (book == null){
            return null;
        }
        book.sections = sectionDao.selectByBid(bid);

        return book;
    }

    public void addSection(int bid, String name) throws SQLException {
        sectionDao.insert(bid, name);
    }
}
