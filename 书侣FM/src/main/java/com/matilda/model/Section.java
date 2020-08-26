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

    @Override
    public String toString() {
        return "Section{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
