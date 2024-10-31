package com.delivery.api.domain.repository;

import java.util.List;
import java.util.Optional;

public interface CategoryProductRepository<T> {

    T save(T entity);
    Optional<T> findById(Long id);
    List<T> findAll(int page, int size);

}
