package com.delivery.api.domain.entity;

import com.delivery.api.domain.enums.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private Long id;
    private String name;
    private Double shippingFee;
    private Boolean active;
    private Kitchen kitchen;
    private Address address;
    private List<User> users = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<PaymentMethod> paymentMethods = new ArrayList<>();

    public Restaurant() {}

    public Restaurant(Long id, String name, Double shippingFee, Boolean active, Kitchen kitchen, Address address) {
        this.id = id;
        this.name = name;
        this.shippingFee = shippingFee;
        this.active = active;
        this.kitchen = kitchen;
        this.address = address;
    }

    public void addUsers(User user) {
        this.users.add(user);
    }

    public void addProducts(Product product) {
        this.products.add(product);
    }

    public void addPaymentMethods(PaymentMethod paymentMethod) {
        this.paymentMethods.add(paymentMethod);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Product> getProducts() {
        return products;
    }

}
