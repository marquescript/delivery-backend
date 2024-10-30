package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.ProductRepository;
import com.delivery.api.infra.persistence.jpa_entity.ProductPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("jpa")
public interface ProductRepositoryJpa extends JpaRepository<ProductPersistence, Long>, ProductRepository<ProductPersistence> {

    @Query("FROM ProductPersistence p WHERE p.restaurantPersistence.id = :restaurantId")
    List<ProductPersistence> findProductsByRestaurant(Long restaurantId, Pageable pageable);

    @Override
    default List<ProductPersistence> findProductsByRestaurant(Long restaurantId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return findProductsByRestaurant(restaurantId, pageable);
    }

    @Query("FROM ProductPersistence p WHERE p.restaurantPersistence.id = :restaurantId AND p.id = :productId")
    Optional<ProductPersistence> findProductByRestaurant(Long restaurantId, Long productId);

    @Query("FROM ProductPersistence  p WHERE p.restaurantPersistence.id = :restaurantId AND p.categoryProductPersistence.id = :categoryId")
    List<ProductPersistence> findProductsByRestaurantAndCategory(Long restaurantId, Long categoryId, Pageable pageable);

    @Override
    default List<ProductPersistence> findProductsByRestaurantAndCategory(Long restaurantId, Long categoryId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return findProductsByRestaurantAndCategory(restaurantId, categoryId, pageable);
    }

    @Query("FROM ProductPersistence p WHERE p.restaurantPersistence.id = :restaurantId AND p.name LIKE %:name%")
    List<ProductPersistence> findProductsByRestaurantAndName(Long restaurantId, String name, Pageable pageable);

    @Override
    default List<ProductPersistence> findProductsByRestaurantAndName(Long restaurantId, String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return findProductsByRestaurantAndName(restaurantId, name, pageable);
    }

}
