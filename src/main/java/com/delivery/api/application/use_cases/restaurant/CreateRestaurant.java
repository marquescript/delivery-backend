package com.delivery.api.application.use_cases.restaurant;

import com.delivery.api.application.service.*;
import com.delivery.api.domain.entity.Restaurant;
import com.delivery.api.domain.entity.User;
import com.delivery.api.domain.enums.UserRoleEnum;
import com.delivery.api.infra.http.dto.RestaurantRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateRestaurant {

    private final RestaurantService restaurantService;
    private final KitchenService kitchenService;
    private final CityService cityService;
    private final UserService userService;
    private final UserRoleService userRoleService;

    @Autowired
    public CreateRestaurant(
            RestaurantService restaurantService,
            KitchenService kitchenService,
            CityService cityService,
            UserService userService,
            UserRoleService userRoleService
    ){
            this.restaurantService = restaurantService;
            this.kitchenService = kitchenService;
            this.cityService = cityService;
            this.userService = userService;
            this.userRoleService = userRoleService;
    }

    @Transactional
    public Restaurant execute(RestaurantRequest restaurantRequest){
        Restaurant restaurant = RestaurantRequest.convertDtoToEntity(restaurantRequest);

        this.kitchenService.findKitchen(restaurant.getKitchen().getId());
        this.cityService.findCity(restaurant.getAddress().getCity().getId());

        restaurant = this.restaurantService.createRestaurant(restaurant);
        User user = this.userService.findUser(restaurant.getUsers().get(0).getId());
        this.userRoleService.addRoleToUser(user, UserRoleEnum.RESTAURANT_OWNER);
    }

}
