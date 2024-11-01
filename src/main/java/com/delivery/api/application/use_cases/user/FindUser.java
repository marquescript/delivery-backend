package com.delivery.api.application.use_cases.user;

import com.delivery.api.application.service.UserService;
import com.delivery.api.domain.entity.User;
import com.delivery.api.infra.http.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindUser {

    private final UserService userService;

    @Autowired
    public FindUser(
            UserService userService
    ){
            this.userService = userService;
    }

    public UserResponse execute(Long userId){
        User user  = this.userService.findUser(userId);
        return UserResponse.convertEntityToDto(user);
    }

}
