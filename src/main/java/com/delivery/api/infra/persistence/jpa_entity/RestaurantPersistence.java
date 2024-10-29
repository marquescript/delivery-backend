package com.delivery.api.infra.persistence.jpa_entity;

import com.delivery.api.domain.entity.Restaurant;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class RestaurantPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "shipping_fee")
    private Double shippingFee;

    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kitchen_id")
    private KitchenPersistence kitchenPersistence;

    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressPersistence addressPersistence;

    @ManyToMany
    @JoinTable(name = "restaurant_user", joinColumns = @JoinColumn(name = "restaurant_id"), inverseJoinColumns =
    @JoinColumn(name = "user_id"))
    private List<UserPersistence> userPersistences = new ArrayList<>();

    @OneToMany(mappedBy = "restaurantPersistence")
    private List<ProductPersistence> productPersistences = new ArrayList<>();

    public RestaurantPersistence(Long id, String name, Double shippingFee, Boolean active, KitchenPersistence kitchenPersistence, AddressPersistence addressPersistence) {
        this.id = id;
        this.name = name;
        this.shippingFee = shippingFee;
        this.active = active;
        this.kitchenPersistence = kitchenPersistence;
        this.addressPersistence = addressPersistence;
    }

    public static RestaurantPersistence convertRestaurantToRestaurantPersistence(Restaurant restaurant) {
        return new RestaurantPersistence(
                restaurant.getId(), restaurant.getName(), restaurant.getShippingFee(), restaurant.getActive(),
                KitchenPersistence.convertKitchenToKitchenPersistence(restaurant.getKitchen()),
                AddressPersistence.convertAddressToAddressPersistence(restaurant.getAddress())
        );
    }

    public static Restaurant convertRestaurantPersistenceToRestaurant(RestaurantPersistence restaurantPersistence) {
        return new Restaurant(
                restaurantPersistence.getId(), restaurantPersistence.getName(), restaurantPersistence.getShippingFee(),
                restaurantPersistence.getActive(), KitchenPersistence.convertKitchenPersistenceToKitchen(restaurantPersistence.getKitchenPersistence()),
                AddressPersistence.convertAddressPersistenceToAddress(restaurantPersistence.getAddressPersistence())
        );
    }

    public RestaurantPersistence() {}

    public void addUserPersistence(UserPersistence userPersistence) {
        this.userPersistences.add(userPersistence);
    }

    public void addProductPersistence(ProductPersistence productPersistence){
        this.productPersistences.add(productPersistence);
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

    public KitchenPersistence getKitchenPersistence() {
        return kitchenPersistence;
    }

    public void setKitchenPersistence(KitchenPersistence kitchenPersistence) {
        this.kitchenPersistence = kitchenPersistence;
    }

    public AddressPersistence getAddressPersistence() {
        return addressPersistence;
    }

    public void setAddressPersistence(AddressPersistence addressPersistence) {
        this.addressPersistence = addressPersistence;
    }

    public List<UserPersistence> getUserPersistences() {
        return userPersistences;
    }

    public List<ProductPersistence> getProductPersistences() {
        return productPersistences;
    }

}
