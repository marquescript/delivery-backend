package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.RestaurantRepository;
import com.delivery.api.infra.persistence.jpa_entity.RestaurantPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("jpa")
public interface RestaurantRepositoryJpa extends JpaRepository<RestaurantPersistence, Long>, RestaurantRepository<RestaurantPersistence> {

    @Query("FROM RestaurantPersistence r WHERE r.addressPersistence.cityPersistence.id = :cityId")
    List<RestaurantPersistence> findAllByCity(Long cityId, Pageable pageable);

    default List<RestaurantPersistence> findAllByCity(Long cityId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return findAllByCity(cityId, pageable);
    }

    @Query("FROM RestaurantPersistence r WHERE r.addressPersistence.cityPersistence.id = :cityId AND r.kitchenPersistence.id = :kitchenId")
    List<RestaurantPersistence> findRestaurantsByCityAndKitchen(Long cityId, Long kitchenId, Pageable pageable);

    @Override
    default List<RestaurantPersistence> findRestaurantsByCityAndKitchen(Long cityId, Long kitchenId, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return findRestaurantsByCityAndKitchen(cityId, kitchenId, pageable);
    }



}
