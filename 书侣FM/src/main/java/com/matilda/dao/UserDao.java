package com.matilda.dao;

import com.matilda.model.User;
import com.matilda.util.DBUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-26 10:29
 **/

//由Service调用，处理一些SQL相关的工作
//java代码表示的增删查改（INSERT/DELETE/SELECT/UPDATE）
    //关于用户的密码，不要保存明文密码
    //如果数据泄露了，则所有用户的密码也会跟着全部泄露
    //一般都是保存做完hash的密码（这里选择sha-256这个hash算法）
public class UserDao {
    public User insert(String username,String plainPassword) throws SQLException {
        String password = encrypt(plainPassword);

        String sql = "insert into users (username,password) values (?,?)";

        try(Connection c = DBUtil.getConnection()){
            try (PreparedStatement s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){//可以获取insert之后的id
                s.setString(1,username);
                s.setString(2,password);
                s.executeUpdate();//进行插入

                try(ResultSet r = s.getGeneratedKeys()){
                    //没有插入成功
                    if (!r.next()){
                        return null;
                    }

                    return new User(r.getInt(1),username);
                }
            }
        }
    }

    public User select(String username,String plainPassword) throws SQLException {
        String password = encrypt(plainPassword);

        String sql = "select uid,username from users where username = ? and password = ?";

        try(Connection c = DBUtil.getConnection()){
            try(PreparedStatement s = c.prepareStatement(sql)){
                s.setString(1,username);
                s.setString(2,password);

                try(ResultSet r = s.executeQuery()){
                    if (!r.next()){
                        return null;
                    }

                    return new User(r.getInt(1),username);
                }
            }
        }
    }

    //这个做法实际上也不适合生产环境真正使用
    //但至少比明文的情况要安全一点
    private String encrypt(String plain){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = plain.getBytes();
            byte[] digest = messageDigest.digest(bytes);
            StringBuilder sb = new StringBuilder();
            for (byte b:digest) {
                sb.append(String.format("%02x",b));
            }
            return sb.toString();
        }catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    //测验sha-256这个hash算法
    /*public static void main(String[] args) {
        String a = "123";
        UserDao userDao = new UserDao();
        String encrypt = userDao.encrypt(a);
        System.out.println(encrypt);
    }*/
}
