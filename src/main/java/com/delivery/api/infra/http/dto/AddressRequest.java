package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.Address;
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
        CityRequest city
) {

    public static Address convertToEntity(AddressRequest addressRequest){
        return new Address(
                addressRequest.id,
                addressRequest.cep,
                addressRequest.publicPlace,
                addressRequest.number,
                addressRequest.complement,
                addressRequest.neighborhood,
                CityRequest.convertDtoToEntity(addressRequest.city)
        );
    }

}
