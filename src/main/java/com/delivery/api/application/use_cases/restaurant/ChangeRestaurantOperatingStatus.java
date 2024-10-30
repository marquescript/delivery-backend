package com.delivery.api.application.use_cases.restaurant;

import com.delivery.api.application.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangeRestaurantOperatingStatus {

    private final RestaurantService restaurantService;

    @Autowired
    public ChangeRestaurantOperatingStatus(
            RestaurantService restaurantService
    ){
        this.restaurantService = restaurantService;
    }

    public void execute(Long restaurantId, Boolean status){
        this.restaurantService.changeRestaurantOperatingStatus(restaurantId, status);
    }

}
