package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.User;

public record UserResponse(
        Long id,
        String name,
        String email,
        String password,
        String phoneNumber
) {

    public static UserResponse convertEntityToDto(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhoneNumber()
        );
    }

    public static User convertDtoToEntity(UserResponse userResponse){
        return new User(
                userResponse.id(),
                userResponse.name(),
                userResponse.email(),
                userResponse.password(),
                userResponse.phoneNumber(),
                null
        );
    }

}
