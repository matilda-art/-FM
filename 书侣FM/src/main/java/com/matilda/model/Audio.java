package com.matilda.model;

import java.io.InputStream;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-27 11:57
 **/
public class Audio {
    public String contentType;
    public InputStream inputStream;

    public Audio(String type, InputStream content) {
        this.contentType = type;
        this.inputStream = content;
    }
}
