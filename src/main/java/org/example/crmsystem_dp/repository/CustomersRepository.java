package org.example.crmsystem_dp.repository;

import org.example.crmsystem_dp.entities.Customers;
import org.example.crmsystem_dp.entities.Users;
import org.example.crmsystem_dp.interfaces.DataAccessObject;
import org.example.crmsystem_dp.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomersRepository implements DataAccessObject<Customers> {

    private final JdbcTemplate jdbcTemplate;
    private final CustomerMapper rowMapper;

    @Autowired
    public CustomersRepository(JdbcTemplate jdbcTemplate, CustomerMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public void save(Customers customer) {
        jdbcTemplate.update(
                "INSERT INTO customers (name, email, phone, status) VALUES (?, ?, ?, ?)",
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getStatus()
        );
    }

    @Override
    public void delete(Customers customer) {
        jdbcTemplate.update("DELETE FROM customers WHERE id = ?", customer.getId());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM customers WHERE id = ?", id);
    }

    @Override
    public void update(Long id, Customers customer) {
        jdbcTemplate.update(
                "UPDATE customers SET name = ?, email = ?, phone = ?, status = ? WHERE id = ?",
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getStatus(),
                id
        );
    }

    @Override
    public List<Customers> findAll() {
        return jdbcTemplate.query("SELECT * FROM customers", rowMapper);
    }

    @Override
    public Optional<Customers> findByID(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "SELECT * FROM customers WHERE id = ?",
                    rowMapper,
                    id
            ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public Optional<Customers> findByEmail(String email) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "SELECT * FROM customers WHERE email = ?",
                    rowMapper,
                    email
            ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}