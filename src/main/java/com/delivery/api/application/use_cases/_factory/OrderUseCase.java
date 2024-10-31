package com.delivery.api.application.use_cases._factory;

import com.delivery.api.application.use_cases.order.CreateOrder;
import com.delivery.api.application.use_cases.order.FindOrderByRestaurant;
import com.delivery.api.application.use_cases.order.FindOrdersByRestaurant;
import com.delivery.api.domain.entity.Order;
import com.delivery.api.infra.http.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderUseCase {

    private final FindOrderByRestaurant findOrderByRestaurant;
    private final FindOrdersByRestaurant findOrdersByRestaurant;
    private final CreateOrder createOrder;

    @Autowired
    public OrderUseCase(
            FindOrderByRestaurant findOrderByRestaurant,
            FindOrdersByRestaurant findOrdersByRestaurant,
            CreateOrder createOrder
    ){
            this.findOrderByRestaurant = findOrderByRestaurant;
            this.findOrdersByRestaurant = findOrdersByRestaurant;
            this.createOrder = createOrder;
    }

    public List<Order> findOrdersByRestaurantUseCase(Long restaurantId, int page, int size){
        return this.findOrdersByRestaurant.execute(restaurantId, page, size);
    }

    public Order findOrderByRestaurantUseCase(Long restaurantId, Long orderId){
        return this.findOrderByRestaurant.execute(restaurantId, orderId);
    }

    public Order createOrderUseCase(OrderRequest orderRequest){
        return this.createOrder.execute(orderRequest);
    }

}
