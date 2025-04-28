package org.example.crmsystem_dp.mappers;

import org.example.crmsystem_dp.entities.Notifications;
import org.example.crmsystem_dp.entities.Users;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class NotificationMapper implements RowMapper<Notifications> {
    @Override
    public Notifications mapRow(ResultSet rs, int rowNum) throws SQLException {
        Notifications notification = new Notifications();
        notification.setId(rs.getLong("id"));
        notification.setUser(rs.getObject("user_id", Users.class));
        notification.setMessage(rs.getString("message"));
        notification.setRead(rs.getBoolean("is_read"));
        return notification;
    }
}
