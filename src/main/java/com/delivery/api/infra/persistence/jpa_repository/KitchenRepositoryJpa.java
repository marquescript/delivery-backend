package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.KitchenRepository;
import com.delivery.api.infra.persistence.jpa_entity.KitchenPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("jpa")
public interface KitchenRepositoryJpa extends JpaRepository<KitchenPersistence, Long>, KitchenRepository<KitchenPersistence> {

    @Override
    default List<KitchenPersistence> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return findAll(pageable).getContent();
    }

}
