package com.delivery.api.application.use_cases.user;

import com.delivery.api.application.service.RestaurantService;
import com.delivery.api.application.service.UserRoleService;
import com.delivery.api.application.service.UserService;
import com.delivery.api.domain.entity.Restaurant;
import com.delivery.api.domain.entity.User;
import com.delivery.api.domain.entity.UserRole;
import com.delivery.api.domain.enums.UserRoleEnum;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class AddUserRoleRestaurantEmployee {

    private final UserService userService;
    private final UserRoleService userRoleService;
    private final RestaurantService restaurantService;

    public AddUserRoleRestaurantEmployee(
            UserService userService,
            UserRoleService userRoleService,
            RestaurantService restaurantService
    ){
            this.userService = userService;
            this.userRoleService = userRoleService;
            this.restaurantService = restaurantService;
    }

    @Transactional
    public void execute(Long restaurantId, Long userId){
        Restaurant restaurant = this.restaurantService.findRestaurant(restaurantId);
        User user = this.userService.findUser(userId);

        this.userRoleService.addRoleToUser(user, UserRoleEnum.RESTAURANT_EMPLOYEE);
        this.restaurantService.addEmployeeToRestaurant(restaurant, user);

    }

}
