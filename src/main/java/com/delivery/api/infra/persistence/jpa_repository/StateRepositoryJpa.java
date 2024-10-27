package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.StateRepository;
import com.delivery.api.infra.persistence.jpa_entity.StatePersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jpa")
public interface StateRepositoryJpa extends JpaRepository<StatePersistence, Long>, StateRepository<StatePersistence> {
}
