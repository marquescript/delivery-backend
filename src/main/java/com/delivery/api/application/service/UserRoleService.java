package com.delivery.api.application.service;

import com.delivery.api.domain.entity.User;
import com.delivery.api.domain.entity.UserRole;
import com.delivery.api.domain.enums.UserRoleEnum;
import com.delivery.api.domain.repository.UserRepository;
import com.delivery.api.domain.repository.UserRolesRepository;
import com.delivery.api.infra.persistence.jpa_entity.UserPersistence;
import com.delivery.api.infra.persistence.jpa_entity.UserRolePersistence;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

@Service
public class UserRoleService {

    private final UserRolesRepository<UserRolePersistence> userRolesRepository;
    private final UserRepository<UserPersistence> userRepository;

    @Autowired
    public UserRoleService(
            @Qualifier("jpa") UserRolesRepository<UserRolePersistence> userRolesRepository,
            @Qualifier("jpa") UserRepository<UserPersistence> userRepository
            ){
            this.userRolesRepository = userRolesRepository;
            this.userRepository = userRepository;
    }

    public UserRole findUserRole(UserRoleEnum userRoleEnum) {
        return this.userRolesRepository.findByRole(userRoleEnum)
                .map(UserRolePersistence::convertUserRolePersistenceToUserRole)
                .orElse(null);
    }

    @Transactional
    public UserRole createUserRole(UserRole userRole){
        UserRole userRoleExists = this.findUserRole(userRole.getUserRole());
        if(userRoleExists != null){
            throw new IllegalArgumentException("User role already exists");
        }
        UserRolePersistence userRolePersistence = UserRolePersistence.convertUserRoleToUserRolePersistence(userRole);
        userRolePersistence = this.userRolesRepository.save(userRolePersistence);
        return UserRolePersistence.convertUserRolePersistenceToUserRole(userRolePersistence);
    }

    @Transactional
    public void addRoleToUser(User user, UserRoleEnum userRoleEnum){
        UserRole userRole = this.findUserRole(userRoleEnum);
        if(user.getUserRoles().contains(userRole)){
            throw new IllegalArgumentException("User already has this role");
        }
        user.addUserRole(userRole);
        this.userRepository.save(UserPersistence.convertUserToUserPersistence(user));
    }

    @Transactional
    public void removeRoleToUser(User user, UserRoleEnum userRoleEnum){
        UserRole userRole = this.findUserRole(userRoleEnum);
        if(!user.getUserRoles().contains(userRole)){
            throw new IllegalArgumentException("User does not have this role");
        }
        user.getUserRoles().remove(userRole);
        this.userRepository.save(UserPersistence.convertUserToUserPersistence(user));
    }

}
