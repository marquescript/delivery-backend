package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.Restaurant;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RestaurantRequest(
        Long id,
        @NotBlank
        String name,
        @Min(1)
        Double shippingFee,
        @NotNull
        KitchenRequest kitchen,
        @NotNull
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
