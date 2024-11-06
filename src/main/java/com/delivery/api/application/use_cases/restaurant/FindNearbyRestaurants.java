package com.delivery.api.application.use_cases.restaurant;

import com.delivery.api.application.service.AddressService;
import com.delivery.api.application.service.RestaurantService;
import com.delivery.api.domain.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FindNearbyRestaurants {

    private final RestaurantService restaurantService;
    private final AddressService addressService;

    @Autowired
    public FindNearbyRestaurants(
            RestaurantService restaurantService,
            AddressService addressService
    ){
            this.restaurantService = restaurantService;
            this.addressService = addressService;
    }

    public List<Restaurant> execute(Long cityId, double latitude, double longitude, double maxDistance){

        List<Restaurant> allRestaurants = this.restaurantService.findAllRestaurantsByCity(cityId, 0, 100);
        List<Restaurant> nearbyRestaurants = new ArrayList<>();

        allRestaurants.forEach(restaurant -> {
            double distance = this.addressService.calculateDsitanceBetweenTwoCoordinates(latitude, longitude, restaurant.getLatitude(), restaurant.getLongitude());
            if(distance <= maxDistance){
                nearbyRestaurants.add(restaurant);
            }
        });
        return nearbyRestaurants;
    }

}
