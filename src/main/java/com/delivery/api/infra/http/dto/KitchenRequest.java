package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.Kitchen;
import com.delivery.api.infra.http.handler.validation.GroupsValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record KitchenRequest(

        @NotNull(groups = GroupsValidation.GetKitchenId.class)
        Long id,

        @NotBlank
        String name
) {

    public static Kitchen convertDtoToEntity(KitchenRequest kitchenRequest){
        return new Kitchen(kitchenRequest.id(), kitchenRequest.name());
    }

}
