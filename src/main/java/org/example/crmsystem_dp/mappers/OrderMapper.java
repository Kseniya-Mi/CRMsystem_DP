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
        order.setDescription(rs.getString("description"));
        order.setStatus(Orders.OrderStatus.valueOf(rs.getString("status")));
        order.setCustomer(rs.getLong("customer_id"));
        order.setExecutor(rs.getLong("executor_id"));
        order.setDate(rs.getDate("date").toLocalDate());
        order.setSum(rs.getDouble("sum"));
        return order;
    }
}
