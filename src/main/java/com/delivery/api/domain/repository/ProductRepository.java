package com.delivery.api.domain.repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository <T>{

    List<T> findAll(int page, int size);
    Optional<T> findById(Long id);
    T save(T entity);
    void deleteById(Long id);
    List<T> findProductsByRestaurantId(Long restaurantId, int page, int size);
    T findProductByRestaurantId(Long restaurantId, Long productId);

}
