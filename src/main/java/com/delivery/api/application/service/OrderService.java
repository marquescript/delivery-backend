package com.delivery.api.application.service;

import com.delivery.api.domain.entity.Order;
import com.delivery.api.domain.entity.Restaurant;
import com.delivery.api.domain.enums.OrderStatus;
import com.delivery.api.domain.exception.EntityNotFound;
import com.delivery.api.domain.repository.OrderRepository;
import com.delivery.api.infra.persistence.jpa_entity.OrderPersistence;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository<OrderPersistence> orderRepository;

    @Autowired
    public OrderService(
            @Qualifier("jpa") OrderRepository<OrderPersistence> orderRepository
    ){
            this.orderRepository = orderRepository;
    }

    public List<Order> findOrdersByRestaurant(Long restaurantId, int page, int size){
        List<OrderPersistence> orderPersistences = this.orderRepository.findOrdersByRestaurant(restaurantId, page, size);
        return orderPersistences.stream().map(OrderPersistence::convertOrderPersistenceToOrder).toList();
    }

    public Order findOrderByRestaurant(Long restaurantId, Long orderId){
        OrderPersistence orderPersistence = this.orderRepository.findOrderByRestaurant(restaurantId, orderId).orElseThrow(() -> new EntityNotFound("Order not found"));
        return OrderPersistence.convertOrderPersistenceToOrder(orderPersistence);
    }

    @Transactional
    public Order createOrder(Order order, Restaurant restaurant){

        Double subTotalOrder = order.getItemOrders().stream().map(item -> {
            Double totalItemPrice = item.getUnitPrice() * item.getQuantity();
            item.setTotalPrice(totalItemPrice);
            item.setOrder(order);
            return totalItemPrice;
        }).reduce(0.0, Double::sum);

        Double shippingFee = calculateShippingFee(restaurant, order);

        order.setSubTotal(subTotalOrder);
        order.setShippingFee(shippingFee);
        order.setTotalValue(subTotalOrder + shippingFee);
        order.setOrderStatus(OrderStatus.CREATED);

        OrderPersistence orderPersistence = OrderPersistence.convertOrderToOrderPersistence(order);
        orderPersistence = this.orderRepository.save(orderPersistence);
        return OrderPersistence.convertOrderPersistenceToOrder(orderPersistence);

    }

    private static Double calculateShippingFee(Restaurant restaurant, Order order){
        return 0.0;
    }



}
