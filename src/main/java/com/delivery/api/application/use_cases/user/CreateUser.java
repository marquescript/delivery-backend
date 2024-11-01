package com.delivery.api.application.use_cases.user;

import com.delivery.api.application.service.UserRoleService;
import com.delivery.api.application.service.UserService;
import com.delivery.api.domain.entity.User;
import com.delivery.api.domain.enums.UserRoleEnum;
import com.delivery.api.infra.http.dto.UserRequest;
import com.delivery.api.infra.http.dto.UserResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {

    private final UserService userService;
    private final UserRoleService userRoleService;

    @Autowired
    public CreateUser(
            UserService userService,
            UserRoleService userRoleService
    ){
            this.userService = userService;
            this.userRoleService = userRoleService;
    }

    @Transactional
    public UserResponse execute(UserRequest userRequest){
        User user = UserRequest.convertDtoToEntity(userRequest);
        User userCreated = this.userService.createUser(user);
        this.userRoleService.addRoleToUser(user, UserRoleEnum.USER);
        return UserResponse.convertEntityToDto(userCreated);
    }

}
