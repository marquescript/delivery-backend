package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.Address;
import com.delivery.api.infra.http.handler.validation.GroupsValidation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;

public record AddressRequest(

        @NotNull(groups = GroupsValidation.GetAddressId.class)
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

        @Valid
        @ConvertGroup(from = Default.class, to = GroupsValidation.GetCityId.class)
        CityRequest city
) {

    public static Address convertToEntity(AddressRequest addressRequest){
        return new Address(
                addressRequest.id(),
                addressRequest.cep(),
                addressRequest.publicPlace(),
                addressRequest.number(),
                addressRequest.complement(),
                addressRequest.neighborhood(),
                CityRequest.convertDtoToEntity(addressRequest.city())
        );
    }

}
