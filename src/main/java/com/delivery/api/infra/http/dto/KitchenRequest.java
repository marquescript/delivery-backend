package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.Kitchen;
import jakarta.validation.constraints.NotBlank;

public record KitchenRequest(
        Long id,
        @NotBlank
        String name
) {

    public static Kitchen convertDtoToEntity(KitchenRequest kitchenRequest){
        return new Kitchen(kitchenRequest.id(), kitchenRequest.name());
    }

}
