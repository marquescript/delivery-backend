package com.delivery.api.application.use_cases.restaurant;

import com.delivery.api.application.service.CityService;
import com.delivery.api.application.service.KitchenService;
import com.delivery.api.application.service.RestaurantService;
import com.delivery.api.domain.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindRestaurantsByCityAndKitchen {

    private final RestaurantService restaurantService;

    @Autowired
    public FindRestaurantsByCityAndKitchen(
            RestaurantService restaurantService
    ){
            this.restaurantService = restaurantService;
    }

    public List<Restaurant> execute(Long cityId, Long kitchenId, int page, int size){
        return this.restaurantService.findRestaurantsByCityAndKitchen(cityId, kitchenId, page, size);
    }

}
