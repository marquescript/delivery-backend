package com.delivery.api.application.use_cases.user;

import com.delivery.api.application.service.UserService;
import com.delivery.api.domain.entity.User;
import com.delivery.api.infra.http.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {

    private final UserService userService;

    @Autowired
    public UpdateUser(
            UserService userService
    ){
        this.userService = userService;
    }

    public UserResponse execute(Long userId, UserResponse userResponse){
        User user = UserResponse.convertDtoToEntity(userResponse);
        User userUpdated = this.userService.updateUser(userId, user);
        return UserResponse.convertEntityToDto(userUpdated);
    }

}
