package org.example.crmsystem_dp.repository;

import org.example.crmsystem_dp.entities.Users;
import org.example.crmsystem_dp.interfaces.UserInterface;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepository implements UserInterface<Users> {
    @Override
    public void save(Users entity) {

    }

    @Override
    public void delete(Users entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Long id, Users entity) {

    }

    @Override
    public List<Users> findAll() {
        return List.of();
    }

    @Override
    public Optional<Users> findByID(Long id) {
        return Optional.empty();
    }
}
