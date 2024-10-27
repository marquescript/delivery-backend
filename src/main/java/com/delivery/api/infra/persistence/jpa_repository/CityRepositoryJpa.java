package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.CityRepository;
import com.delivery.api.infra.persistence.jpa_entity.CityPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jpa")
public interface CityRepositoryJpa extends JpaRepository<CityPersistence, Long>, CityRepository<CityPersistence> {
}
