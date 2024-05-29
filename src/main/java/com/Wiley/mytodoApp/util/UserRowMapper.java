package com.Wiley.mytodoApp.util;

import com.Wiley.mytodoApp.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user=new User();
        user.setUid(rs.getInt("user_id"));
        user.setFirstname(rs.getString("user_firstname"));
        user.setLastname(rs.getString("user_lastname"));
        user.setEmail(rs.getString("user_email"));
        user.setContact(rs.getString("user_contact"));
        return user;
    }
}
