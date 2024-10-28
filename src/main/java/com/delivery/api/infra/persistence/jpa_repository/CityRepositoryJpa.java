package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.CityRepository;
import com.delivery.api.infra.persistence.jpa_entity.CityPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("jpa")
public interface CityRepositoryJpa extends JpaRepository<CityPersistence, Long>, CityRepository<CityPersistence> {

    @Override
    default List<CityPersistence> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return findAll(pageable).getContent();
    }

}
