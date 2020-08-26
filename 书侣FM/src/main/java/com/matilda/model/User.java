package com.matilda.model;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-25 19:56
 **/

import java.util.Objects;

/**
 * 一般来说，model这类对象，都需要覆写
 * 1. toString
 * 2. equals
 * 3. hashCode
*/
public class User {
    public int uid;
    public String username;

    //空的构造方法
    public User(){
    }

    //带参数的构造方法
    public User(int uid,String username){
        this.uid = uid;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//两个引用是不是指向同一个对象
        //两个对象的类型是否一致
        if (o == null || getClass() != o.getClass()) return false;
        //判断重要属性是否一样
        User user = (User) o;
        return uid == user.uid &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username);
    }
}
