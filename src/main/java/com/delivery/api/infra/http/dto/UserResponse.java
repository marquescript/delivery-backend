package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.User;

public record UserResponse(
        Long id,
        String name,
        String password,
        String phoneNumber
) {

    public static UserResponse convertEntityToDto(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getPhoneNumber()
        );
    }

}
