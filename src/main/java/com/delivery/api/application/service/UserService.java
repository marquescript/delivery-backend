package com.delivery.api.application.service;

import com.delivery.api.domain.repository.UserRepository;
import com.delivery.api.infra.persistence.jpa_entity.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository<UserPersistence> userRepository;

    @Autowired
    public UserService(
            @Qualifier("jpa") UserRepository<UserPersistence> userRepository
    ){
            this.userRepository = userRepository;
    }




}
