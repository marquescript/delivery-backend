package com.delivery.api.infra.persistence.jpa_entity;

import com.delivery.api.domain.entity.Kitchen;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kitchen")
public class KitchenPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "kitchenPersistence")
    private List<RestaurantPersistence> restaurantPersistence = new ArrayList<>();

    public KitchenPersistence(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public KitchenPersistence() {}

    public void addRestaurantPersistence(RestaurantPersistence restaurantPersistence) {
        this.restaurantPersistence.add(restaurantPersistence);
    }

    public static KitchenPersistence convertKitchenToKitchenPersistence(Kitchen kitchen) {
        KitchenPersistence kitchenPersistence = new KitchenPersistence(kitchen.getId(), kitchen.getName());
        kitchen.getRestaurants()
                .forEach(restaurant -> kitchenPersistence.addRestaurantPersistence(RestaurantPersistence.convertRestaurantToRestaurantPersistence(restaurant)));
        return kitchenPersistence;
    }

    public static Kitchen convertKitchenPersistenceToKitchen(KitchenPersistence kitchenPersistence) {
        Kitchen kitchen = new Kitchen(kitchenPersistence.getId(), kitchenPersistence.getName());
        kitchenPersistence.getRestaurantPersistence()
                .forEach(restaurantPersistence -> kitchen.addRestaurant(RestaurantPersistence.convertRestaurantPersistenceToRestaurant(restaurantPersistence)));
        return kitchen;
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

    public List<RestaurantPersistence> getRestaurantPersistence() {
        return restaurantPersistence;
    }

}
