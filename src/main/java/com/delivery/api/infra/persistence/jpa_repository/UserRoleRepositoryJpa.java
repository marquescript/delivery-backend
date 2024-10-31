package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.enums.UserRoleEnum;
import com.delivery.api.domain.repository.UserRolesRepository;
import com.delivery.api.infra.persistence.jpa_entity.UserRolePersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Qualifier("jpa")
public interface UserRoleRepositoryJpa extends JpaRepository<UserRolePersistence, Long>, UserRolesRepository<UserRolePersistence> {

    @Query("FROM UserRolePersistence u WHERE u.userRoleEnum = :userRoleEnum")
    Optional<UserRolePersistence> findByRole(UserRoleEnum userRoleEnum);

}
