package com.delivery.api.application.use_cases.restaurant;

import com.delivery.api.application.service.CityService;
import com.delivery.api.application.service.KitchenService;
import com.delivery.api.application.service.RestaurantService;
import com.delivery.api.domain.entity.Restaurant;
import com.delivery.api.infra.http.dto.RestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateRestaurant {

    private final RestaurantService restaurantService;
    private final KitchenService kitchenService;
    private final CityService cityService;

    @Autowired
    public UpdateRestaurant(
            RestaurantService restaurantService,
            KitchenService kitchenService,
            CityService cityService
    ){
           this.restaurantService = restaurantService;
           this.kitchenService = kitchenService;
           this.cityService = cityService;
    }

    public Restaurant execute(Long restaurantId, RestaurantRequest restaurantrRequest){
        Restaurant restaurant = RestaurantRequest.convertDtoToEntity(restaurantrRequest);

        this.kitchenService.findKitchen(restaurant.getKitchen().getId());
        this.cityService.findCity(restaurant.getAddress().getCity().getId());

        return this.restaurantService.updateRestaurant(restaurantId, restaurant);
    }

}
