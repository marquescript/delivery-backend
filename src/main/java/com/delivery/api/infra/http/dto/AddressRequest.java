package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.Address;
import com.delivery.api.domain.entity.City;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AddressRequest(
        Long id,
        @Size(min = 8, max = 8)
        String cep,
        @NotBlank
        String publicPlace,
        @NotBlank
        String number,
        String complement,
        @NotBlank
        String neighborhood,
        @NotNull
        City city
) {

    public static Address convertToEntity(AddressRequest addressRequest){
        return new Address(
                addressRequest.id,
                addressRequest.cep,
                addressRequest.publicPlace,
                addressRequest.number,
                addressRequest.complement,
                addressRequest.neighborhood,
                addressRequest.city
        );
    }

}
