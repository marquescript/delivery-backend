package com.delivery.api.application.use_cases.restaurant;

import com.delivery.api.application.service.RestaurantService;
import com.delivery.api.domain.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindRestaurant {

    private final RestaurantService restaurantService;

    @Autowired
    public FindRestaurant(
            RestaurantService restaurantService
    ){
            this.restaurantService = restaurantService;
    }

    public Restaurant execute(Long restaurantId){
        return this.restaurantService.findRestaurant(restaurantId);
    }

}
