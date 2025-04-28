package org.example.crmsystem_dp.mappers;

import org.example.crmsystem_dp.entities.Executors;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ExecutorMapper implements RowMapper<Executors> {
    @Override
    public Executors mapRow(ResultSet rs, int rowNum) throws SQLException {
        Executors executor = new Executors();
        executor.setId(rs.getLong("id"));
        executor.setName(rs.getString("name"));
        executor.setEmail(rs.getString("email"));
        executor.setPhone(rs.getString("phone"));
        executor.setSkills(rs.getString("skills"));
        executor.setStatus(rs.getString("status"));
        return executor;
    }
}
