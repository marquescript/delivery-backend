package com.delivery.api.domain.entity;

import com.delivery.api.domain.enums.OrderStatus;
import com.delivery.api.domain.enums.PaymentMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;
    private Double subTotal;
    private Double shippingFee;
    private Double totalValue;
    private LocalDateTime creationDate;
    private LocalDateTime confirmationDate;
    private LocalDateTime cancellationDate;
    private LocalDateTime deliveryDate;
    private OrderStatus orderStatus;
    private User user;
    private Restaurant restaurant;
    private Address address;
    private PaymentMethod paymentMethod;
    private List<ItemOrder> itemOrders = new ArrayList<>();

    public Order() {}

    public Order(Long id, Double subTotal, Double shippingFee, Double totalValue, LocalDateTime creationDate, LocalDateTime confirmationDate, LocalDateTime cancellationDate, LocalDateTime deliveryDate, OrderStatus orderStatus, User user, Restaurant restaurant, Address address, PaymentMethod paymentMethod) {
        this.id = id;
        this.subTotal = subTotal;
        this.shippingFee = shippingFee;
        this.totalValue = totalValue;
        this.creationDate = creationDate;
        this.confirmationDate = confirmationDate;
        this.cancellationDate = cancellationDate;
        this.deliveryDate = deliveryDate;
        this.orderStatus = orderStatus;
        this.user = user;
        this.restaurant = restaurant;
        this.address = address;
        this.paymentMethod = paymentMethod;
    }

    public void addItemOrder(ItemOrder order) {
        this.itemOrders.add(order);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<ItemOrder> getItemOrders() {
        return itemOrders;
    }

}
