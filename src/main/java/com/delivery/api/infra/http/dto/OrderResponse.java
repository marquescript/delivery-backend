package com.delivery.api.infra.http.dto;

import com.delivery.api.domain.entity.Order;
import com.delivery.api.domain.enums.OrderStatus;
import com.delivery.api.domain.enums.PaymentMethod;

import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Long id,
        Double subTotalm,
        Double shippingFee,
        Double totalValue,
        LocalDateTime creationDate,
        LocalDateTime confirmationDate,
        LocalDateTime cancellationDate,
        LocalDateTime deliveryDate,
        OrderStatus orderStatus,
        PaymentMethod paymentMethod,
        List<ItemOrderRequest> itemOrderRequests
) {

    public static OrderResponse convertEntityToDto(Order order){

        List<ItemOrderRequest> itemOrderRequests = order.getItemOrders().stream().map(ItemOrderRequest::convertEntityToDto).toList();

        return new OrderResponse(
                order.getId(),
                order.getSubTotal(),
                order.getShippingFee(),
                order.getTotalValue(),
                order.getCreationDate(),
                order.getConfirmationDate(),
                order.getCancellationDate(),
                order.getDeliveryDate(),
                order.getOrderStatus(),
                order.getPaymentMethod(),
                itemOrderRequests
        );
    }

}
