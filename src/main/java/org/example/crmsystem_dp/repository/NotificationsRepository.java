package org.example.crmsystem_dp.repository;

import org.example.crmsystem_dp.entities.Notifications;
import org.example.crmsystem_dp.interfaces.NotificationsInterface;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NotificationsRepository implements NotificationsInterface<Notifications> {
    @Override
    public void save(Notifications entity) {

    }

    @Override
    public void delete(Notifications entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Long id, Notifications entity) {

    }

    @Override
    public List<Notifications> findAll() {
        return List.of();
    }

    @Override
    public Optional<Notifications> findByID(Long id) {
        return Optional.empty();
    }
}
