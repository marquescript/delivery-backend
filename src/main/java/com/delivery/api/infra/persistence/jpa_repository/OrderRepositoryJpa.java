package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.OrderRepository;
import com.delivery.api.infra.persistence.jpa_entity.OrderPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jpa")
public interface OrderRepositoryJpa extends JpaRepository<OrderPersistence, Long>, OrderRepository<OrderPersistence> {
}
