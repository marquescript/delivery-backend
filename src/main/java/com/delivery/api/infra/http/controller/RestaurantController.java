package com.delivery.api.infra.http.controller;

import com.delivery.api.application.use_cases._factory.RestaurantUseCase;
import com.delivery.api.domain.entity.Restaurant;
import com.delivery.api.infra.http.dto.RestaurantRequest;
import com.delivery.api.infra.http.handler.validation.GroupsValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantUseCase restaurantUseCase;

    @Autowired
    public RestaurantController(
            RestaurantUseCase restaurantUseCase
    ){
            this.restaurantUseCase = restaurantUseCase;
    }


    @GetMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> findRestaurant(@PathVariable Long restaurantId){
        Restaurant restaurant = this.restaurantUseCase.findRestaurantUseCase(restaurantId);
        return ResponseEntity.status(HttpStatus.OK).body(restaurant);
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<Restaurant>> findRestauranstByCity(@PathVariable Long cityId, @RequestParam(value = "page", defaultValue = "0") int page,
                                                                 @RequestParam(value = "size", defaultValue = "10") int size){
        List<Restaurant> restaurants = this.restaurantUseCase.findRestaurantsByCityUseCase(cityId, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(restaurants);
    }

    @GetMapping("/city/{cityId}/kitchen/{kitchenId}")
    public ResponseEntity<List<Restaurant>> findRestaurantsByCityAndKitchen(@PathVariable Long cityId, @PathVariable Long kitchenId,@RequestParam(value = "page", defaultValue = "0") int page,
                                                                            @RequestParam(value = "size", defaultValue = "10") int size){
        List<Restaurant> restaurants = this.restaurantUseCase.findRestaurantsByCityAndKitchenUseCase(cityId, kitchenId, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(restaurants);
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody @Validated(GroupsValidation.CreateRestaurantValidation.class) RestaurantRequest restaurantRequest){
        Restaurant restaurant = this.restaurantUseCase.createRestaurantUseCase(restaurantRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long restaurantId, @RequestBody RestaurantRequest restaurantRequest){
        Restaurant restaurant = this.restaurantUseCase.updateRestaurantUseCase(restaurantId, restaurantRequest);
        return ResponseEntity.status(HttpStatus.OK).body(restaurant);
    }

    @PutMapping("/{restaurantId}/active")
    public ResponseEntity<Void> changeRestaurantOperatingStatus(@PathVariable Long restaurantId, @RequestBody Boolean status){
        this.restaurantUseCase.changeRestaurantOperatingStatusUseCase(restaurantId, status);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
