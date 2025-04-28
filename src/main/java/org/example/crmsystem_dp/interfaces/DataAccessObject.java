package org.example.crmsystem_dp.interfaces;

import java.util.List;
import java.util.Optional;

public interface DataAccessObject <T>{
    void save (T entity);

    void delete(T entity);

    void deleteById(Long id);

    void update(Long id, T entity);

    List<T> findAll();

    Optional<T> findByID(Long id);
}
