package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.RestaurantRepository;
import com.delivery.api.infra.persistence.jpa_entity.RestaurantPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jpa")
public interface RestaurantRepositoryJpa extends JpaRepository<RestaurantPersistence, Long>, RestaurantRepository<RestaurantPersistence> {
}
