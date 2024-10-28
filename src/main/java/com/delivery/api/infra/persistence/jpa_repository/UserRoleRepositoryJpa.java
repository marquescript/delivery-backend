package com.delivery.api.infra.persistence.jpa_repository;

import com.delivery.api.domain.repository.UserRolesRepository;
import com.delivery.api.infra.persistence.jpa_entity.UserRolePersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jpa")
public interface UserRoleRepositoryJpa extends JpaRepository<UserRolePersistence, Long>, UserRolesRepository<UserRolePersistence> {

}
