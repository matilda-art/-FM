package com.matilda.model;

import java.util.Objects;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-26 15:43
 **/

public class Section {
    public int sid;
    public String name;
    //如果关联声音，uuid就是保存声音的uuid
    //否则，uuid == null
    public String uuid;

    public Section(){
    }

    public Section(int sid,String uuid,String name){
        this.sid = sid;
        this.uuid = uuid;
        this.name = name;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
