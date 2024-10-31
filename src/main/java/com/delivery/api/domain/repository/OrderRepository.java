package com.delivery.api.domain.repository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository<T> {

    T save(T entity);
    void deleteById(Long id);
    List<T> findOrdersByRestaurant(Long restaurantId, int page, int size);
    Optional<T> findOrderByRestaurant(Long restaurantId, Long orderId);
}
