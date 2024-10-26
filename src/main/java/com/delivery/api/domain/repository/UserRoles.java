package com.delivery.api.domain.repository;

public interface UserRoles <T>{

    T save(T entity);
    T findByName(String name);

}
