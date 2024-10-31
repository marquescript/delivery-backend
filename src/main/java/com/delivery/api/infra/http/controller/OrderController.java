package com.delivery.api.infra.http.controller;

import com.delivery.api.application.use_cases._factory.OrderUseCase;
import com.delivery.api.domain.entity.Order;
import com.delivery.api.infra.http.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class OrderController {

    private final OrderUseCase orderUseCase;

    @Autowired
    public OrderController(
            OrderUseCase orderUseCase
    ){
            this.orderUseCase = orderUseCase;
    }

    @GetMapping("/{restaurantId}/order")
    public ResponseEntity<List<Order>> findOrdersByRestaurant(@PathVariable Long restaurantId, @RequestParam(value = "page", defaultValue = "0") int page,
                                                              @RequestParam(value = "size", defaultValue = "0") int size){
        List<Order> orders = this.orderUseCase.findOrdersByRestaurantUseCase(restaurantId, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping("/{restaurantId}/order/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Long restaurantId, @PathVariable Long orderId){
        Order order = this.orderUseCase.findOrderByRestaurantUseCase(restaurantId, orderId);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @PostMapping("/{restaurantId}/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest){
        Order order = this.orderUseCase.createOrderUseCase(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

}
