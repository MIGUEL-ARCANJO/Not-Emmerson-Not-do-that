package com.example.persistenciasql.respository;

import java.util.List;

public interface CrudRepository<T> {
    Long criar(T object);
    List<T> listAll();
    void updateObject();
    void deleteObject();
}
