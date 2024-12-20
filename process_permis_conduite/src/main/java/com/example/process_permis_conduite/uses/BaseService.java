package com.example.process_permis_conduite.uses;

import java.util.List;

public interface BaseService<T, ID> {
    T save(T dto);
    T update(ID id, T dto);
    void delete(ID id);
    T findById(ID id);
    List<T> findAll();
}
