package com.delivery.api.domain.repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository <T>{

    Optional<T> findByEmail(String name);
    List<T> findAll(int page, int size);
    Optional<T> findById(Long id);
    T save(T entity);
    void deleteById(Long id);
    Optional<T> findByCpf(String cpf);
    Optional<T> findByPhoneNumber(String phoneNumber);

}
