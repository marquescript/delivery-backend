package com.delivery.api.domain.entity;

import com.delivery.api.domain.enums.UserRoleEnum;

public class UserRole {

    private Long id;
    private UserRoleEnum userRole;

    public UserRole() {}

    public UserRole(Long id, UserRoleEnum userRole) {
        this.id = id;
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
    }
}
