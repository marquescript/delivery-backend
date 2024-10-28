package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.UserRepository;
import com.delivery.api.infra.persistence.jpa_entity.UserPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("jpa")
public interface UserRepositoryJpa extends JpaRepository<UserPersistence, Long>, UserRepository<UserPersistence> {

    @Override
    default List<UserPersistence> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return findAll(pageable).getContent();
    }

}
