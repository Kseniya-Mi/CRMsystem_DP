package org.example.crmsystem_dp.mappers;

import org.example.crmsystem_dp.entities.Customers;
import org.example.crmsystem_dp.entities.Executors;
import org.example.crmsystem_dp.entities.Orders;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderMapper implements RowMapper<Orders> {
    @Override
    public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
        Orders order = new Orders();
        order.setId(rs.getLong("id"));
        order.setCustomer(rs.getObject("customer_id", Customers.class));
        order.setExecutor(rs.getObject("executor_id", Executors.class));
        order.setDescription(rs.getString("description"));
        order.setStatus(rs.getString("status"));
        return order;
    }
}
