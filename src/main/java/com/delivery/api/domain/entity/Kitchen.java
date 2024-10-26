package com.delivery.api.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Kitchen {

    private Long id;
    private String name;
    private List<Restaurant> restaurants = new ArrayList<>();

    public Kitchen() {}

    public void addRestaurant(Restaurant restaurant){
        this.restaurants.add(restaurant);
    }

    public Kitchen(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

}
