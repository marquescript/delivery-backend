package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.OrderRepository;
import com.delivery.api.infra.persistence.jpa_entity.KitchenPersistence;
import com.delivery.api.infra.persistence.jpa_entity.OrderPersistence;
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
public interface OrderRepositoryJpa extends JpaRepository<OrderPersistence, Long>, OrderRepository<OrderPersistence> {

    @Query("FROM OrderPersistence o WHERE o.restaurantPersistence.id = :restaurantId ORDER BY o.creationDate ASC")
    List<OrderPersistence> findOrdersByRestaurant(Long restaurantId, Pageable pageable);

    @Override
    default List<OrderPersistence> findOrdersByRestaurant(Long restaurantId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return findOrdersByRestaurant(restaurantId, pageable);
    }

    @Query("FROM OrderPersistence o WHERE o.restaurantPersistence.id = :restaurantId AND o.id = :orderId")
    Optional<OrderPersistence> findOrderByRestaurant(Long restaurantId, Long orderId);


}
