package com.delivery.api.application.use_cases.order;

import com.delivery.api.application.service.OrderService;
import com.delivery.api.domain.entity.Order;
import com.delivery.api.infra.http.dto.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindOrderByRestaurant {

    private final OrderService orderService;

    @Autowired
    public FindOrderByRestaurant(
            OrderService orderService
    ){
        this.orderService = orderService;
    }

    public OrderResponse execute(Long restaurantId, Long orderId){
        Order order = this.orderService.findOrderByRestaurant(restaurantId, orderId);
        return OrderResponse.convertEntityToDto(order);
    }

}
