package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(

        Long id,

        @NotBlank
        String name,

        @Email
        String email,

        @NotBlank
        @Min(6)
        String password,

        @Size(min = 11, max = 11)
        String phoneNumber,

        @Size(min = 11, max = 11)
        String cpf

) {

    public static User convertDtoToEntity(UserRequest userRequest){
        return new User(
            userRequest.id(),
            userRequest.name(),
            userRequest.email(),
            userRequest.password(),
            userRequest.phoneNumber(),
            userRequest.cpf()
        );
    }

}
