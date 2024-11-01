package com.delivery.api.application.use_cases.user;

import com.delivery.api.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserPassword {

    private final UserService userService;

    @Autowired
    public UpdateUserPassword(
            UserService userService
    ){
        this.userService = userService;
    }

    public void execute(Long userId, String currentPassword, String newPassword){
        this.userService.updateUserPassword(userId, currentPassword, newPassword);
    }


}
