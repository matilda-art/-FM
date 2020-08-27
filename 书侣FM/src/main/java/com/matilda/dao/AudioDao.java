package com.matilda.dao;

import com.matilda.model.Audio;
import com.matilda.util.DBUtil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-26 23:57
 **/

public class AudioDao {
    public void insert(int sid, String uuid, String contentType, InputStream inputStream) throws SQLException {
        String sql = "insert into audios (sid, uuid, type, content) values (?, ?, ?, ?)";

        try (Connection c = DBUtil.getConnection()) {
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setInt(1, sid);
                s.setString(2, uuid);
                s.setString(3, contentType);
                s.setBlob(4, inputStream);

                s.executeUpdate();
            }
        }
    }

    public Audio select(String uuid) throws SQLException {
        String sql = "select type, content from audios where uuid = ?";

        try (Connection c = DBUtil.getConnection()) {
            try (PreparedStatement s = c.prepareStatement(sql)) {
                s.setString(1, uuid);

                try (ResultSet r = s.executeQuery()) {
                    if (!r.next()) {
                        return null;
                    }

                    return new Audio(r.getString("type"), r.getBinaryStream("content"));
                }
            }
        }
    }
}
