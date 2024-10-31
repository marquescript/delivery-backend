package com.delivery.api.application.use_cases.order;

import com.delivery.api.application.service.OrderService;
import com.delivery.api.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindOrderByRestaurant {

    private final OrderService orderService;

    @Autowired
    public FindOrderByRestaurant(
            OrderService orderService
    ){
        this.orderService = orderService;
    }

    public Order execute(Long restaurantId, Long orderId){
        return this.orderService.findOrderByRestaurant(restaurantId, orderId);
    }

}
