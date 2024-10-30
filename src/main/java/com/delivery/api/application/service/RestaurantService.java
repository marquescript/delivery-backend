package com.delivery.api.application.service;

import com.delivery.api.domain.entity.Restaurant;
import com.delivery.api.domain.exception.EntityNotFound;
import com.delivery.api.domain.repository.RestaurantRepository;
import com.delivery.api.infra.persistence.jpa_entity.RestaurantPersistence;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository<RestaurantPersistence> restaurantRepository;

    @Autowired
    public RestaurantService(
            @Qualifier("jpa") RestaurantRepository<RestaurantPersistence> restaurantRepository
    ){
            this.restaurantRepository = restaurantRepository;
    }

    public Restaurant findRestaurant(Long restaurantId){
        RestaurantPersistence restaurantPersistence = this.restaurantRepository.findById(restaurantId).orElseThrow(() -> new EntityNotFound("Restaurant not found"));
        return RestaurantPersistence.convertRestaurantPersistenceToRestaurant(restaurantPersistence);
    }

    public List<Restaurant> findAllRestaurantsByCity(Long cityId, int page, int size){
        List<RestaurantPersistence> restaurantPersistences = this.restaurantRepository.findAllByCity(cityId, page, size);
        return restaurantPersistences.stream().map(RestaurantPersistence::convertRestaurantPersistenceToRestaurant).toList();
    }

    public List<Restaurant> findRestaurantsByCityAndKitchen(Long cityId, Long kitchenId, int page, int size){
        List<RestaurantPersistence> restaurantPersistences = this.restaurantRepository.findRestaurantsByCityAndKitchen(cityId, kitchenId, page, size);
        return restaurantPersistences.stream().map(RestaurantPersistence::convertRestaurantPersistenceToRestaurant).toList();
    }

    @Transactional
    public Restaurant createRestaurant(Restaurant restaurant){
        RestaurantPersistence restaurantPersistence = RestaurantPersistence.convertRestaurantToRestaurantPersistence(restaurant);
        restaurantPersistence = this.restaurantRepository.save(restaurantPersistence);
        return RestaurantPersistence.convertRestaurantPersistenceToRestaurant(restaurantPersistence);
    }

    @Transactional
    public void changeRestaurantOperatingStatus(Long restaurantId, Boolean status){
        Restaurant restaurant = this.findRestaurant(restaurantId);
        if(restaurant.getActive() != status){
            restaurant.setActive(status);
            RestaurantPersistence restaurantPersistence = RestaurantPersistence.convertRestaurantToRestaurantPersistence(restaurant);
            this.restaurantRepository.save(restaurantPersistence);
        }
    }

    public Restaurant updateRestaurant(Long restaurantId, Restaurant restaurant){
        this.findRestaurant(restaurantId);
        restaurant.setId(restaurantId);
        RestaurantPersistence restaurantPersistence = RestaurantPersistence.convertRestaurantToRestaurantPersistence(restaurant);
        restaurantPersistence = this.restaurantRepository.save(restaurantPersistence);
        return RestaurantPersistence.convertRestaurantPersistenceToRestaurant(restaurantPersistence);
    }

}
