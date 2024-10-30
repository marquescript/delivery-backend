package com.delivery.api.domain.repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository <T>{

    List<T> findProductsByRestaurant(Long restaurantId, int page, int size);
    List<T> findProductsByRestaurantAndName(Long restaurantId, String name, int page, int size);
    Optional<T> findProductByRestaurant(Long restaurantId, Long productId);
    List<T> findProductsByRestaurantAndCategory(Long restaurantId, Long categoryId, int page, int size);
    T save(T entity);
    void deleteById(Long id);

}
