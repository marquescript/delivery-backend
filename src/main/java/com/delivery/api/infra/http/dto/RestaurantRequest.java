package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.Restaurant;
import com.delivery.api.infra.http.handler.validation.GroupsValidation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;

public record RestaurantRequest(

        Long id,

        @NotBlank
        String name,

        @Min(1)
        Double shippingFee,

        @Valid
        @ConvertGroup(from = Default.class, to = GroupsValidation.GetKitchenId.class)
        KitchenRequest kitchen,

        @Valid
        @ConvertGroup(from = Default.class, to = GroupsValidation.GetAddressId.class)
        AddressRequest address
) {

    public static Restaurant convertDtoToEntity(RestaurantRequest restaurantRequest){
        return new Restaurant(
                restaurantRequest.id(),
                restaurantRequest.name(),
                restaurantRequest.shippingFee(),
                null,
                KitchenRequest.convertDtoToEntity(restaurantRequest.kitchen()),
                AddressRequest.convertToEntity(restaurantRequest.address())
        );
    }

}
