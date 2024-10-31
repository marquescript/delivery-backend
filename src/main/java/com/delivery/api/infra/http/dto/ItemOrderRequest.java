package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.ItemOrder;
import com.delivery.api.infra.http.handler.validation.GroupsValidation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;

public record ItemOrderRequest(

        Long id,

        @Min(1)
        Integer quantity,

        String observation,

        @Valid
        @ConvertGroup(from = Default.class, to = GroupsValidation.GetProductId.class)
        ProductRequest product

) {

    public static ItemOrder convertDtoToEntity(ItemOrderRequest itemOrderRequest){
        return new ItemOrder(
                itemOrderRequest.id(),
                itemOrderRequest.quantity(),
                null,
                null,
                itemOrderRequest.observation(),
                null,
                ProductRequest.convertDtoToEntity(itemOrderRequest.product())
        );
    }

}
