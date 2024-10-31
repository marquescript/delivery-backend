package com.delivery.api.domain.repository;

import com.delivery.api.domain.enums.UserRoleEnum;

import java.util.Optional;

public interface UserRolesRepository<T>{

    T save(T entity);
    Optional<T> findByRole(UserRoleEnum userRoleEnum);

}
