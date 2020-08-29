package com.matilda.DBUtil;

import com.matilda.util.DBUtil;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-29 22:35
 **/
public class DBUtilTest {

    @Test
    public void getConnection() throws SQLException {
        Assert.assertNotNull(DBUtil.getConnection());
    }
}
