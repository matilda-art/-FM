package com.matilda.dao;

import com.matilda.model.Section;
import com.matilda.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 书侣FM
 * @description
 * @author: matilda
 * @create: 2020-08-26 15:50
 **/

public class SectionDao {
    public void insert(int bid,String name) throws SQLException {
        String sql = "insert into sections (bid,name) values (?,?)";

        try (Connection c = DBUtil.getConnection()){
            try(PreparedStatement s = c.prepareStatement(sql)){
                s.setInt(1,bid);
                s.setString(2,name);

                s.executeUpdate();
            }
        }
    }

    public List<Section> selectByBid(int bid) throws SQLException {
        String sql = "select name from sections where bid = ? order by sid";
        List<Section> sections = new ArrayList<>();

        try (Connection c = DBUtil.getConnection()){
            try (PreparedStatement s = c.prepareStatement(sql)){
                s.setInt(1,bid);

                try (ResultSet r = s.executeQuery()){
                    while (r.next()){
                        Section section = new Section(r.getString("name"));
                        sections.add(section);
                    }
                }
            }
        }
        return sections;
    }
}
