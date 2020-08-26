package com.matilda.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-25 21:33
 **/

public class DBUtil {
    private static volatile DataSource dataSource = null;

    private static DataSource initDataSource(){
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("cardiac02200059");
        mysqlDataSource.setDatabaseName("shulv");
        mysqlDataSource.setCharacterEncoding("utf8");
        mysqlDataSource.setUseSSL(false);

        return mysqlDataSource;
    }

    //用单例模式进行连接
    public static Connection getConnection() throws SQLException {
        if(dataSource == null){
            synchronized (DBUtil.class){
                if(dataSource == null){
                    dataSource = initDataSource();
                }
            }
        }

        return dataSource.getConnection();
    }
}