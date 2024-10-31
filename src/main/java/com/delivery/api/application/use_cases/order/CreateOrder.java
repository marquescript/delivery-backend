package com.delivery.api.application.use_cases.order;

import com.delivery.api.application.service.OrderService;
import com.delivery.api.application.service.ProductService;
import com.delivery.api.application.service.RestaurantService;
import com.delivery.api.domain.entity.Order;
import com.delivery.api.domain.entity.Product;
import com.delivery.api.domain.entity.Restaurant;
import com.delivery.api.infra.http.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateOrder {

    private final OrderService orderService;
    private final RestaurantService restaurantService;
    private final ProductService productService;

    @Autowired
    public CreateOrder(
            OrderService orderService,
            RestaurantService restaurantService,
            ProductService productService
    ){
            this.orderService = orderService;
            this.restaurantService = restaurantService;
            this.productService = productService;
    }

    public Order execute(OrderRequest orderRequest){

        Order order = OrderRequest.convertDtoToEntity(orderRequest);

        Restaurant restaurant = this.restaurantService.findRestaurant(order.getRestaurant().getId());

        order.getItemOrders().forEach(item -> {
            Product product = this.productService.findProductByRestaurant(restaurant.getId(), item.getProduct().getId());
            item.setUnitPrice(product.getPrice());
        });

        Order createdOrder = this.orderService.createOrder(order, restaurant);
        return order;
    }

}
