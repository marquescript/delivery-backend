package com.delivery.api.domain.repository;

public interface UserRolesRepository<T>{

    T save(T entity);
    T findByName(String name);

}
