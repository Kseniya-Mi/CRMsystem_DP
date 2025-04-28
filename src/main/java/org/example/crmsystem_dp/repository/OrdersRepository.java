package org.example.crmsystem_dp.repository;

import org.example.crmsystem_dp.entities.Orders;
import org.example.crmsystem_dp.interfaces.DataAccessObject;
import org.example.crmsystem_dp.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrdersRepository implements DataAccessObject<Orders> {
    private final JdbcTemplate jdbcTemplate;
    private final OrderMapper rowMapper;

    @Autowired
    public OrdersRepository(JdbcTemplate jdbcTemplate, OrderMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public void save(Orders order) {
        jdbcTemplate.update(
                "INSERT INTO orders (customer_id, executor_id, description, status) VALUES (?, ?, ?, ?)",
                order.getCustomer(),
                order.getExecutor(),
                order.getDescription(),
                order.getStatus()
        );
    }

    @Override
    public void delete(Orders order) {
        jdbcTemplate.update("DELETE FROM orders WHERE id = ?", order.getId());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM orders WHERE id = ?", id);
    }

    @Override
    public void update(Long id, Orders order) {
        jdbcTemplate.update(
                "UPDATE orders SET customer_id = ?, executor_id = ?, description = ?, status = ? WHERE id = ?",
                order.getCustomer(),
                order.getExecutor(),
                order.getDescription(),
                order.getStatus(),
                id
        );
    }

    @Override
    public List<Orders> findAll() {
        return jdbcTemplate.query("SELECT * FROM orders", rowMapper);
    }

    @Override
    public Optional<Orders> findByID(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "SELECT * FROM orders WHERE id = ?",
                    rowMapper,
                    id
            ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<Orders> findByCustomerId(Long customerId) {
        return jdbcTemplate.query("SELECT * FROM orders WHERE customer_id = ?", rowMapper, customerId);
    }
}




