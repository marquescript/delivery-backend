package com.delivery.api.application.use_cases.kitchen;

import com.delivery.api.application.service.KitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteKitchen {

    private final KitchenService kitchenService;

    @Autowired
    public DeleteKitchen(
            KitchenService kitchenService
    ){
        this.kitchenService = kitchenService;
    }

    public void execute(Long kitchenId){
        this.kitchenService.deleteKitchen(kitchenId);
    }

}
