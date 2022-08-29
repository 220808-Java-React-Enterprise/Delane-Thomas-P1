package com.revature.reimbursementapi.daos;

import java.util.List;
import java.util.UUID;

public interface CRUDDAO<T> {

    void save(T obj);
    List<T> getAll();
    void update(T obj);
    void delete(UUID id);
}
