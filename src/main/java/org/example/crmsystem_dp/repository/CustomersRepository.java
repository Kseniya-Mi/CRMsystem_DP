package org.example.crmsystem_dp.repository;

import org.example.crmsystem_dp.entities.Customers;
import org.example.crmsystem_dp.interfaces.CustomerInterface;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomersRepository implements CustomerInterface<Customers> {

    @Override
    public void save(Customers entity) {

    }
    @Override
    public void delete(Customers entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Long id, Customers entity) {

    }

    @Override
    public List<Customers> findAll() {
        return List.of();
    }

    @Override
    public Optional<Customers> findByID(Long id) {
        return Optional.empty();
    }
}
