package org.example.crmsystem_dp.repository;

public interface DataAcsessObject<T> {

    void save (T entity);
    void update (T entity);
    void delete (T entity);
    void deleteById(int id);
}
