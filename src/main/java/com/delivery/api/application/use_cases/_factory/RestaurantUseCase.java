package com.delivery.api.application.use_cases._factory;

import com.delivery.api.application.use_cases.restaurant.*;
import com.delivery.api.domain.entity.Restaurant;
import com.delivery.api.infra.http.dto.RestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantUseCase {

    private final ChangeRestaurantOperatingStatus changeRestaurantOperatingStatus;
    private final CreateRestaurant createRestaurant;
    private final FindRestaurant findRestaurant;
    private final FindRestaurantsByCity findRestaurantsByCity;
    private final FindRestaurantsByCityAndKitchen findRestaurantsByCityAndKitchen;
    private final UpdateRestaurant updateRestaurant;

    @Autowired
    public RestaurantUseCase(
            ChangeRestaurantOperatingStatus changeRestaurantOperatingStatus,
            CreateRestaurant createRestaurant,
            FindRestaurant findRestaurant,
            FindRestaurantsByCity findRestaurantsByCity,
            FindRestaurantsByCityAndKitchen findRestaurantsByCityAndKitchen,
            UpdateRestaurant updateRestaurant
    ){
            this.changeRestaurantOperatingStatus = changeRestaurantOperatingStatus;
            this.createRestaurant = createRestaurant;
            this.findRestaurant = findRestaurant;
            this.findRestaurantsByCity = findRestaurantsByCity;
            this.findRestaurantsByCityAndKitchen = findRestaurantsByCityAndKitchen;
            this.updateRestaurant = updateRestaurant;
    }

    public void changeRestaurantOperatingStatusUseCase(Long restaurantId, Boolean status){
        this.changeRestaurantOperatingStatus.execute(restaurantId, status);
    }

    public Restaurant createRestaurantUseCase(RestaurantRequest restaurantRequest){
        return this.createRestaurant.execute(restaurantRequest);
    }

    public Restaurant findRestaurantUseCase(Long restaurantId){
        return this.findRestaurant.execute(restaurantId);
    }

    public List<Restaurant> findRestaurantsByCityUseCase(Long cityId, int page, int size){
        return this.findRestaurantsByCity.execute(cityId, page, size);
    }

    public List<Restaurant> findRestaurantsByCityAndKitchenUseCase(Long cityId, Long kitchenId, int page, int size){
        return this.findRestaurantsByCityAndKitchen.execute(cityId, kitchenId, page, size);
    }

    public Restaurant updateRestaurantUseCase(Long restaurantId, RestaurantRequest restaurantRequest){
        return this.updateRestaurant.execute(restaurantId, restaurantRequest);
    }
}
