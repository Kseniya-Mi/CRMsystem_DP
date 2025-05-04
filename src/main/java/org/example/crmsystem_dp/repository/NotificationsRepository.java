package org.example.crmsystem_dp.repository;

import org.example.crmsystem_dp.entities.Notifications;
import org.example.crmsystem_dp.entities.Users;
import org.example.crmsystem_dp.interfaces.DataAccessObject;
import org.example.crmsystem_dp.mappers.NotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NotificationsRepository implements DataAccessObject<Notifications> {
    private final JdbcTemplate jdbcTemplate;
    private final NotificationMapper rowMapper;

    @Autowired
    public NotificationsRepository(JdbcTemplate jdbcTemplate, NotificationMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public void save(Notifications notification) {
        jdbcTemplate.update(
                "INSERT INTO notifications (user_id, message, is_read, created_at) VALUES (?, ?, ?, ?)",
                notification.getUser(),
                notification.getMessage(),
                notification.isRead()
        );
    }

    @Override
    public void delete(Notifications notification) {
        jdbcTemplate.update("DELETE FROM notifications WHERE id = ?", notification.getId());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM notifications WHERE id = ?", id);
    }

    @Override
    public void update(Long id, Notifications notification) {
        jdbcTemplate.update(
                "UPDATE notifications SET user = ?, message = ?, is_read = ? WHERE id = ?",
                notification.getUser(),
                notification.getMessage(),
                notification.isRead(),
                id
        );
    }

    @Override
    public List<Notifications> findAll() {
        return jdbcTemplate.query("SELECT * FROM notifications", rowMapper);
    }

    @Override
    public Optional<Notifications> findByID(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "SELECT * FROM notifications WHERE id = ?",
                    rowMapper,
                    id
            ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<Notifications> findByUserId(Long userId) {
        return jdbcTemplate.query("SELECT * FROM notifications WHERE user_id = ?", rowMapper, userId);
    }
}




