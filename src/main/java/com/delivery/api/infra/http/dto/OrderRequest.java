package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.Order;
import com.delivery.api.domain.enums.PaymentMethod;

import java.util.List;

public record OrderRequest(

        Long id,

        RestaurantRequest restaurant,

        AddressRequest address,

        PaymentMethod paymentMethod,

        List<ItemOrderRequest> itemOrders

) {

    public static Order convertDtoToEntity(OrderRequest orderRequest){
        Order order = new Order(
                orderRequest.id(),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                RestaurantRequest.convertDtoToEntity(orderRequest.restaurant()),
                AddressRequest.convertToEntity(orderRequest.address()),
                orderRequest.paymentMethod
        );

        orderRequest.itemOrders().forEach(itemOrderRequest -> order.addItemOrder(ItemOrderRequest.convertDtoToEntity(itemOrderRequest)));
        return order;
    }

}
