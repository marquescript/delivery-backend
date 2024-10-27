package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.KitchenRepository;
import com.delivery.api.infra.persistence.jpa_entity.KitchenPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jpa")
public interface KitchenRepositoryJpa extends JpaRepository<KitchenPersistence, Long>, KitchenRepository<KitchenPersistence> {
}
