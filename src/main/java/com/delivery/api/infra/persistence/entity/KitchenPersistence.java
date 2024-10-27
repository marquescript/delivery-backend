package com.delivery.api.infra.persistence.entity;

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
