package com.delivery.api.application.use_cases.restaurant;

import com.delivery.api.application.service.CityService;
import com.delivery.api.application.service.KitchenService;
import com.delivery.api.application.service.RestaurantService;
import com.delivery.api.domain.entity.Restaurant;
import com.delivery.api.infra.http.dto.RestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateRestaurant {

    private final RestaurantService restaurantService;
    private final KitchenService kitchenService;
    private final CityService cityService;

    @Autowired
    public CreateRestaurant(
            RestaurantService restaurantService,
            KitchenService kitchenService,
            CityService cityService
    ){
            this.restaurantService = restaurantService;
            this.kitchenService = kitchenService;
            this.cityService = cityService;
    }

    public Restaurant execute(RestaurantRequest restaurantRequest){
        Restaurant restaurant = RestaurantRequest.convertDtoToEntity(restaurantRequest);

        this.kitchenService.findKitchen(restaurant.getKitchen().getId());
        this.cityService.findCity(restaurant.getAddress().getCity().getId());

        return this.restaurantService.createRestaurant(restaurant);
    }

}
