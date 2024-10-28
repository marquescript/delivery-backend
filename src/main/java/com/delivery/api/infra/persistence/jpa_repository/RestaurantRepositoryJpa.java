package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.RestaurantRepository;
import com.delivery.api.infra.persistence.jpa_entity.RestaurantPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("jpa")
public interface RestaurantRepositoryJpa extends JpaRepository<RestaurantPersistence, Long>, RestaurantRepository<RestaurantPersistence> {

    @Override
    default List<RestaurantPersistence> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return findAll(pageable).getContent();
    }

}
