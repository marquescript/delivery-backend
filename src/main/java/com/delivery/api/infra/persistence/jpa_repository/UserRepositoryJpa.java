package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.UserRepository;
import com.delivery.api.infra.persistence.jpa_entity.UserPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jpa")
public interface UserRepositoryJpa extends JpaRepository<UserPersistence, Long>, UserRepository<UserPersistence> {
}
