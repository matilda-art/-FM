package com.matilda.service;

import com.matilda.dao.AudioDao;
import com.matilda.model.Audio;

import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-27 11:17
 **/
public class AudioService {
    private AudioDao audioDao;

    public AudioService(){
        audioDao = new AudioDao();
    }

    public String save(int sid,Part audio) throws IOException, SQLException {
        String uuid = UUID.randomUUID().toString();//直接生成uuid

        audioDao.insert(sid,uuid,audio.getContentType(),audio.getInputStream());

        return uuid;
    }

    //从数据库中获取audio信息
    public Audio get(String uuid) throws SQLException {
        return audioDao.select(uuid);
    }
}
