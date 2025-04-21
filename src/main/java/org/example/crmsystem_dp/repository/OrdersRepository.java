package org.example.crmsystem_dp.repository;

import org.example.crmsystem_dp.entities.Orders;
import org.example.crmsystem_dp.interfaces.OrdersInterface;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrdersRepository implements OrdersInterface<Orders> {
    @Override
    public void save(Orders entity) {

    }

    @Override
    public void delete(Orders entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Long id, Orders entity) {

    }

    @Override
    public List<Orders> findAll() {
        return List.of();
    }

    @Override
    public Optional<Orders> findByID(Long id) {
        return Optional.empty();
    }
}
