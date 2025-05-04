package org.example.crmsystem_dp.repository;

import org.example.crmsystem_dp.entities.Executors;
import org.example.crmsystem_dp.entities.Users;
import org.example.crmsystem_dp.interfaces.DataAccessObject;
import org.example.crmsystem_dp.mappers.ExecutorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExecutorsRepository implements DataAccessObject<Executors> {

    private final JdbcTemplate jdbcTemplate;
    private final ExecutorMapper rowMapper;

    @Autowired
    public ExecutorsRepository(JdbcTemplate jdbcTemplate, ExecutorMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public void save(Executors executor) {
        jdbcTemplate.update(
                "INSERT INTO executors (name, email, phone, skills, status, created_at) VALUES (?, ?, ?, ?, ?, ?)",
                executor.getName(),
                executor.getEmail(),
                executor.getPhone(),
                executor.getSkills(),
                executor.getStatus()
        );
    }

    @Override
    public void delete(Executors executor) {
        jdbcTemplate.update("DELETE FROM executors WHERE id = ?", executor.getId());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM executors WHERE id = ?", id);
    }

    @Override
    public void update(Long id, Executors executor) {
        jdbcTemplate.update(
                "UPDATE executors SET name = ?, email = ?, phone = ?, skills = ?, status = ? WHERE id = ?",
                executor.getName(),
                executor.getEmail(),
                executor.getPhone(),
                executor.getSkills(),
                executor.getStatus(),
                id
        );
    }

    @Override
    public List<Executors> findAll() {
        return jdbcTemplate.query("SELECT * FROM executors", rowMapper);
    }

    @Override
    public Optional<Executors> findByID(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "SELECT * FROM executors WHERE id = ?",
                    rowMapper,
                    id
            ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<Executors> findBySkills(String skill) {
        return jdbcTemplate.query("SELECT * FROM executors WHERE skills LIKE ?", rowMapper, "%" + skill + "%");
    }
}


