package com.delivery.api.domain.repository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository<T> {

    List<T> findAll(int page, int size);
    Optional<T> findById(Long id);
    T save(T entity);
    void deleteById(Long id);
    List<T> findRestaurantByCity(Long cityId, int page, int size);
    List<T> findByCityIdAndKitchenId(Long cityId, Long kitchenId, int page, int size);

}
