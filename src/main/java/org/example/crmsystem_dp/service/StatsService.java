package org.example.crmsystem_dp.service;

import org.example.crmsystem_dp.entities.DashboardStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StatsService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StatsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DashboardStats getDashboardStats() {
        Integer clientCount = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM customers", Integer.class);

        Integer orderCount = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM orders", Integer.class);

        BigDecimal totalRevenue = jdbcTemplate.queryForObject(
                "SELECT COALESCE(SUM(sum), 0) FROM orders",
                BigDecimal.class);

        return new DashboardStats(clientCount, orderCount, totalRevenue);
    }
}
