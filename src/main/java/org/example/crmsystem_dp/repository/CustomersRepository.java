package org.example.crmsystem_dp.repository;

import org.example.crmsystem_dp.entities.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomersRepository implements DataAcsessObject<Customers> {

    @Override
    public void save(Customers entity) {

    }

    @Override
    public void update(Customers entity) {

    }

    @Override
    public void delete(Customers entity) {

    }

    @Override
    public void deleteById(int id) {

    }
}
