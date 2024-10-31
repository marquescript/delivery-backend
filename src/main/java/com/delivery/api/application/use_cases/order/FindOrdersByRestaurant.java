package com.delivery.api.application.use_cases.order;

import com.delivery.api.application.service.OrderService;
import com.delivery.api.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindOrdersByRestaurant {

    private final OrderService orderService;

    @Autowired
    public FindOrdersByRestaurant(
            OrderService orderService
    ){
            this.orderService = orderService;
    }

    public List<Order> execute(Long restaurantId, int page, int size){
        return this.orderService.findOrdersByRestaurant(restaurantId, page, size);
    }

}
