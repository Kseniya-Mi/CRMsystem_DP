package org.example.crmsystem_dp.service;

import org.example.crmsystem_dp.entities.Orders;
import org.example.crmsystem_dp.interfaces.OrderStatusProjection;
import org.example.crmsystem_dp.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

        public List<Orders> getAllOrders() {
            return ordersRepository.findAll();
        }

        public Optional<Orders> getOrderById(Long id) {
            return ordersRepository.findByID(id);
        }

        public List<Orders> getOrdersByStatus(Orders.OrderStatus status) {
            return ordersRepository.findByStatus(status);
        }

        public List<Orders> getOrdersByDate(LocalDate date) {
            return ordersRepository.findByDate(date);
        }

        public void createOrder(Orders order) {
            //order.setDate(LocalDate.now());
            //order.setId();
            ordersRepository.save(order);
        }

        public void updateOrder(Long id, Orders orderDto) {
            Orders existingOrder = ordersRepository.findByID(id)
                    .orElseThrow(() -> new RuntimeException("Order not found"));

            ordersRepository.update(id, orderDto);
        }

        public void deleteOrder(Long id) {
            ordersRepository.deleteById(id);
        }

    public List<Orders> getLatestOrders(int i) {
            return ordersRepository.findTop3ByOrderByCreatedAtDesc();
    }

}
