package com.matilda.model;

import java.util.Objects;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-26 15:43
 **/

public class Section {
    public String name;

    public Section(){
    }

    public Section(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                '}';
    }

}
