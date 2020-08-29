package com.matilda.dao;

import com.matilda.model.Section;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-29 21:57
 **/
public class SectionDaoTest {

    @Test
    public void insert() {
        Section section = new Section();
        section.setSid(111);
        section.setName("matilda");
        section.setUuid("1234");
    }

    @Test
    public void selectByBid() throws SQLException {
        SectionDao sectionDao = new SectionDao();
        sectionDao.selectByBid(1234);
    }
}
