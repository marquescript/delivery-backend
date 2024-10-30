package com.delivery.api.application.use_cases.restaurant;

import com.delivery.api.application.service.RestaurantService;
import com.delivery.api.domain.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindRestaurantsByCity {

    private final RestaurantService restaurantService;

    @Autowired
    public FindRestaurantsByCity(
            RestaurantService restaurantService
    ){
        this.restaurantService = restaurantService;
    }

    public List<Restaurant> execute(Long cityId, int page, int size){
        return this.restaurantService.findAllRestaurantsByCity(cityId, page, size);
    }

}
