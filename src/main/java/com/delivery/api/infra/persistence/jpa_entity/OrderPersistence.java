package com.delivery.api.infra.persistence.jpa_entity;

import com.delivery.api.domain.entity.Order;
import com.delivery.api.domain.enums.OrderStatus;
import com.delivery.api.domain.enums.PaymentMethod;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "general_order")
public class OrderPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double subtotal;

    @Column(name = "shipping_fee")
    private Double shippingFee;

    @Column(name = "total_value")
    private Double totalValue;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "confirmation_date")
    private LocalDateTime confirmationDate;

    @Column(name = "cancellation_date")
    private LocalDateTime cancellationDate;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserPersistence userPersistence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private RestaurantPersistence restaurantPersistence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private AddressPersistence addressPersistence;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "orderPersistence", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ItemOrderPersistence> itemOrderPersistence = new ArrayList<>();

    public OrderPersistence(Long id, Double subtotal, Double shippingFee, Double totalValue, LocalDateTime creationDate, LocalDateTime confirmationDate, LocalDateTime cancellationDate, LocalDateTime deliveryDate, OrderStatus orderStatus, UserPersistence userPersistence, RestaurantPersistence restaurantPersistence, AddressPersistence addressPersistence, PaymentMethod paymentMethod) {
        this.id = id;
        this.subtotal = subtotal;
        this.shippingFee = shippingFee;
        this.totalValue = totalValue;
        this.creationDate = creationDate;
        this.confirmationDate = confirmationDate;
        this.cancellationDate = cancellationDate;
        this.deliveryDate = deliveryDate;
        this.orderStatus = orderStatus;
        this.userPersistence = userPersistence;
        this.restaurantPersistence = restaurantPersistence;
        this.addressPersistence = addressPersistence;
        this.paymentMethod = paymentMethod;
    }

    public OrderPersistence() {}

    public void addItemOrderPersistence(ItemOrderPersistence itemOrderPersistence) {
        this.itemOrderPersistence.add(itemOrderPersistence);
    }

    public static OrderPersistence convertOrderToOrderPersistence(Order order) {
        OrderPersistence orderPersistence = new OrderPersistence(
                order.getId(),
                order.getSubTotal(),
                order.getShippingFee(),
                order.getTotalValue(),
                order.getCreationDate(),
                order.getConfirmationDate(),
                order.getCancellationDate(),
                order.getDeliveryDate(),
                order.getOrderStatus(),
                null,
                RestaurantPersistence.convertRestaurantToRestaurantPersistence(order.getRestaurant()),
                AddressPersistence.convertAddressToAddressPersistence(order.getAddress()),
                order.getPaymentMethod()
        );
        order.getItemOrders().forEach(item -> orderPersistence.addItemOrderPersistence(ItemOrderPersistence.convertItemOrderToItemOrderPersistence(item)));
        return orderPersistence;
    }

    public static Order convertOrderPersistenceToOrder(OrderPersistence orderPersistence) {
        Order order = new Order(
                orderPersistence.getId(),
                orderPersistence.getSubtotal(),
                orderPersistence.getShippingFee(),
                orderPersistence.getTotalValue(),
                orderPersistence.getCreationDate(),
                orderPersistence.getConfirmationDate(),
                orderPersistence.getCancellationDate(),
                orderPersistence.getDeliveryDate(),
                orderPersistence.getOrderStatus(),
                null,
                RestaurantPersistence.convertRestaurantPersistenceToRestaurant(orderPersistence.getRestaurantPersistence()),
                AddressPersistence.convertAddressPersistenceToAddress(orderPersistence.getAddressPersistence()),
                orderPersistence.getPaymentMethod()
        );
        orderPersistence.getItemOrderPersistence().forEach(item -> order.addItemOrder(ItemOrderPersistence.convertItemOrderPersistenceToItemOrder(item)));
        return order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(LocalDateTime confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public LocalDateTime getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(LocalDateTime cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public RestaurantPersistence getRestaurantPersistence() {
        return restaurantPersistence;
    }

    public void setRestaurantPersistence(RestaurantPersistence restaurantPersistence) {
        this.restaurantPersistence = restaurantPersistence;
    }

    public AddressPersistence getAddressPersistence() {
        return addressPersistence;
    }

    public void setAddressPersistence(AddressPersistence addressPersistence) {
        this.addressPersistence = addressPersistence;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<ItemOrderPersistence> getItemOrderPersistence() {
        return itemOrderPersistence;
    }

}
