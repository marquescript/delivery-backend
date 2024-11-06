package com.delivery.api.application.use_cases.restaurant;

import com.delivery.api.application.service.*;
import com.delivery.api.domain.entity.Address;
import com.delivery.api.domain.entity.City;
import com.delivery.api.domain.entity.Restaurant;
import com.delivery.api.domain.entity.User;
import com.delivery.api.domain.enums.UserRoleEnum;
import com.delivery.api.domain.providers.AddressProvider;
import com.delivery.api.infra.http.dto.RestaurantRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CreateRestaurant {

    private final RestaurantService restaurantService;
    private final KitchenService kitchenService;
    private final CityService cityService;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final AddressService addressService;
    private final AddressProvider addressProvider;

    @Autowired
    public CreateRestaurant(
            RestaurantService restaurantService,
            KitchenService kitchenService,
            CityService cityService,
            UserService userService,
            UserRoleService userRoleService,
            AddressService addressService,
            @Qualifier("google-client") AddressProvider addressProvider
    ){
            this.restaurantService = restaurantService;
            this.kitchenService = kitchenService;
            this.cityService = cityService;
            this.userService = userService;
            this.userRoleService = userRoleService;
            this.addressService = addressService;
            this.addressProvider = addressProvider;
    }

    @Transactional
    public Restaurant execute(RestaurantRequest restaurantRequest){
        Restaurant restaurant = RestaurantRequest.convertDtoToEntity(restaurantRequest);

        this.kitchenService.findKitchen(restaurant.getKitchen().getId());
        City city = this.cityService.findCity(restaurant.getAddress().getCity().getId());

        Address address = this.addressService.createAddress(restaurant.getAddress());

        String addressUrl = address.getPublicPlace() + " " + address.getNumber() + " " + address.getNeighborhood() + " " + city.getName();
        Double[] coordinates = this.addressProvider.getCoordinatesFromAddress(addressUrl);
        double latitude = coordinates[0];
        double longitude = coordinates[1];

        restaurant.setLatitude(latitude);
        restaurant.setLongitude(longitude);
        restaurant = this.restaurantService.createRestaurant(restaurant);

        User user = this.userService.findUser(restaurant.getUsers().get(0).getId());
        this.userRoleService.addRoleToUser(user, UserRoleEnum.RESTAURANT_OWNER);

        return restaurant;
    }

}
