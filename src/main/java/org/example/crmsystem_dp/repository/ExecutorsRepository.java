package org.example.crmsystem_dp.repository;

import org.example.crmsystem_dp.entities.Executors;
import org.example.crmsystem_dp.interfaces.ExecutorsInterface;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExecutorsRepository implements ExecutorsInterface<Executors> {
    @Override
    public void save(Executors entity) {

    }

    @Override
    public void delete(Executors entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Long id, Executors entity) {

    }

    @Override
    public List<Executors> findAll() {
        return List.of();
    }

    @Override
    public Optional<Executors> findByID(Long id) {
        return Optional.empty();
    }
}
