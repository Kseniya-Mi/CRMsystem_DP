package org.example.crmsystem_dp.interfaces;

import org.example.crmsystem_dp.entities.Orders;

public interface OrderStatusProjection {
    Orders.OrderStatus getStatus();
    Long getCount();
}
